package com.xhc.common.result;

import com.xhc.common.exception.BizException;
import com.xhc.common.exception.CommonErrorCode;
import com.xhc.common.exception.IErrorCode;
import com.xhc.common.threadlocal.TraceContextThreadLocal;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 通用接口返回标识
 *
 * @author 80387245
 * @create 2022/11/10
 */
@Data
@ToString
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("异常码，1：正常 非1 异常")
    private Integer code;

    @ApiModelProperty("异常消息")
    private String message;

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("替换异常消息提占位符实际值")
    private Object[] args;

    @ApiModelProperty("链路追踪id")
    private String traceId;

    public static <T> ApiResult<T> success() {
        return success(null);
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(CommonErrorCode.SUCCESS.getCode());
        result.setMessage(null);
        result.setData(data);
        result.setTraceId(TraceContextThreadLocal.getTraceId());
        return result;
    }

    public static <T> ApiResult<T> error(T data) {
        ApiResult<T> result = error(CommonErrorCode.ERROR);
        result.setData(data);
        result.setTraceId(TraceContextThreadLocal.getTraceId());
        return result;
    }

    public static <T> ApiResult<T> error(IErrorCode code) {
        return error(code.getCode(), code.getDefaultMessage());
    }

    public static <T> ApiResult<T> error(IErrorCode code, Object... args) {
        return error(code.getCode(), code.getDefaultMessage(), args);
    }

    public static <T> ApiResult<T> error(IErrorCode code, T data, Object[] args) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(code.getCode());
        result.setMessage(code.getDefaultMessage());
        result.setData(data);
        result.setArgs(args);
        result.setTraceId(TraceContextThreadLocal.getTraceId());
        return result;
    }

    public static <T> ApiResult<T> error(Integer code, String message) {
        return error(code, message, null);
    }

    public static <T> ApiResult<T> error(Integer code, String message, Object... args) {
        ApiResult<T> result = new ApiResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setArgs(args);
        result.setTraceId(TraceContextThreadLocal.getTraceId());
        return result;
    }

    public static <T> ApiResult<T> error(BizException e) {
        return error(e.getCode(), e.getMessage(), e.getArgs());
    }
}