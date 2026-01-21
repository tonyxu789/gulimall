package com.xhc.common.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 存放 Trace 信息 线程本地变量
 *
 * @author 80387245
 * @create 2022/11/10
 */
public class TraceContextThreadLocal {

    public static final String TRACE_ID = "traceId";

    public static final String SPAN_ID = "spanId";

    /**
     * traceId
     */
    // private static final ThreadLocal<String> TRACE_ID_LOCAL = new TransmittableThreadLocal<>();
    // 依赖传播失效 先用原生的
    private static final ThreadLocal<String> TRACE_ID_LOCAL = new InheritableThreadLocal<>();

    /**
     * 当前请求在当前服务的spanId
     */
    // private static final ThreadLocal<String> SPAN_ID_LOCAL = new TransmittableThreadLocal<>();
    private static final ThreadLocal<String> SPAN_ID_LOCAL = new InheritableThreadLocal<>();

    /**
     * 保留当前线程span递增的数值
     */
    // public static final ThreadLocal<AtomicInteger> CURRENT_SPAN = new TransmittableThreadLocal<>();
    private static final ThreadLocal<AtomicInteger> CURRENT_SPAN = new InheritableThreadLocal<>();


    public static void setTraceId(String traceId) {
        clearTraceId();
        TRACE_ID_LOCAL.set(traceId);
    }

    public static String getTraceId() {
        return TRACE_ID_LOCAL.get();
    }

    public static void clearTraceId() {
        TRACE_ID_LOCAL.remove();
    }


    public static void setSpanId(String spanId) {
        clearSpanId();
        SPAN_ID_LOCAL.set(spanId);
    }

    public static String getSpanId() {
        return SPAN_ID_LOCAL.get();
    }

    public static void clearSpanId() {
        SPAN_ID_LOCAL.remove();
    }

    public static void clearAll() {
        TRACE_ID_LOCAL.remove();
        SPAN_ID_LOCAL.remove();
        CURRENT_SPAN.remove();
    }

    public static Integer currentSpan() {
        if (CURRENT_SPAN.get() == null) {
            CURRENT_SPAN.set(new AtomicInteger(0));
        }
        return CURRENT_SPAN.get().addAndGet(1);
    }

}