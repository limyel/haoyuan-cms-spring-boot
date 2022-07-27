package com.limyel.haoyuancms.common.util;

public class RedisKey {

    public static String getCaptchaKey(String key) {
        return "captcha:" + key;
    }

}
