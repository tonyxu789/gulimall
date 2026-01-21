package com.xhc.common.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * 存放用户 token 线程本地变量
 *
 * @author 80387245
 * @create 2022/11/10
 */
public class UserContextThreadLocal {

    private static final ThreadLocal<UserContext> TOKEN_THREAD_LOCAL = new TransmittableThreadLocal<>();

    public static void set(UserContext userContext) {
        clear();
        TOKEN_THREAD_LOCAL.set(userContext);
    }

    public static UserContext get() {
        return TOKEN_THREAD_LOCAL.get();
    }

    public static void clear() {
        TOKEN_THREAD_LOCAL.remove();
    }

    public static String getToken() {
        UserContext context = get();
        return context != null ? context.getToken() : null;
    }

    public static String getUserName() {
        UserContext context = get();
        return context != null ? context.getUserName() : null;
    }

    public static String getUser() {
        UserContext context = get();
        return context != null ? context.getUser() : null;
    }

    public static String getUserId() {
        UserContext context = get();
        return context != null ? context.getUserId() : null;
    }

    public static String getLanguage() {
        UserContext context = get();
        return context != null ? context.getLanguage() : null;
    }

}