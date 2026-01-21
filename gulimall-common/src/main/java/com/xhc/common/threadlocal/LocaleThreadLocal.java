package com.xhc.common.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * 存放locale语言的线程本地变量
 *
 * @author 80387245
 * @create 2022/11/10
 */
public class LocaleThreadLocal {

    public static final String LOCALE = "locale";

    private static final ThreadLocal<String> LOCALE_LOCAL = new TransmittableThreadLocal<>();

    public static void set(String traceId) {
        clear();
        LOCALE_LOCAL.set(traceId);
    }

    public static String get() {
        return LOCALE_LOCAL.get();
    }

    public static void clear() {
        LOCALE_LOCAL.remove();
    }

}
