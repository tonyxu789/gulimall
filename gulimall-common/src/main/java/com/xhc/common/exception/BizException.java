package com.xhc.common.exception;


import com.xhc.common.result.ApiResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 异常处理
 *
 * @author 80387245
 * @create 2022/11/11
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1492019471238833084L;

    private Integer code;

    private String codeMessage;

    private Object[] args;

    public BizException() {
    }

    public BizException(Integer code, String codeMessage) {
        super(codeMessage);
        this.code = code;
        this.codeMessage = codeMessage;
    }

    public BizException(Integer code, String codeMessage, Object... args) {
        super(codeMessage);
        this.code = code;
        this.codeMessage = codeMessage;
        this.args = args;
    }

    public BizException(IErrorCode iErrorCode) {
        super(iErrorCode.getDefaultMessage());
        this.code = iErrorCode.getCode();
        this.codeMessage = super.getMessage();
    }

    public BizException(IErrorCode iErrorCode, Object... args) {
        super(iErrorCode.getCodeContent(args));
        this.code = iErrorCode.getCode();
        this.codeMessage = super.getMessage();
        this.args = args;
    }

    public static BizException of(IErrorCode iErrorCode) {
        return new BizException(iErrorCode);
    }

    public static BizException of(Integer code, String codeMessage) {
        return new BizException(code, codeMessage);
    }

    public static BizException of(Integer code, String codeMessage, Object... params) {
        return new BizException(code, codeMessage, params);
    }

    public static BizException of(IErrorCode iErrorCode, Object... params) {
        return new BizException(iErrorCode, params);
    }

    public static <T> BizException of(ApiResult<T> apiResult) {
        return new BizException(apiResult.getCode(), apiResult.getMessage(), apiResult.getArgs());
    }

}