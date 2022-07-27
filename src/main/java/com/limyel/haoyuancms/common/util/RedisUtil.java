package com.limyel.haoyuancms.common.util;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name="redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    @Resource(name="redisTemplate")
    private ListOperations<String, Object> listOperations;

    @Resource(name="redisTemplate")
    private SetOperations<String, Object> setOperations;

    @Resource(name="redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;

    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;

    public final static long NOT_EXPIRE = -1;

    public void set(String key, Object value, long expire) {
        String text = this.toJson(value);
        valueOperations.set(key, text);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value){
        set(key, value, DEFAULT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : JSONUtil.toBean(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    private String toJson(Object object) {
        if(object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return JSONUtil.toJsonStr(object);
    }
}
