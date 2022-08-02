package com.limyel.haoyuancms.common.util;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil {

    public static final String CURRENT_USER = "currentUser";

    private ThreadLocalUtil() {
    }

    // 初始化
    private final static ThreadLocal<Map<String, Object>> THREAD_CONTEXT = ThreadLocal.withInitial(
            () -> new HashMap<>(8)
    );

    // 根据 kye 获取 value
    public static Object get(String key) {
        return THREAD_CONTEXT.get().get(key);
    }

    public static void put(String key, Object value) {
        THREAD_CONTEXT.get().put(key, value);
    }

    public static Object remove(String key) {
        return THREAD_CONTEXT.get().remove(key);
    }

    // 清除整个 Map 的内容
    public static void clear() {
        THREAD_CONTEXT.get().clear();
    }

    // 清除 ThreadLocal 的内容
    public static void clearAll() {
        THREAD_CONTEXT.remove();
    }

}
