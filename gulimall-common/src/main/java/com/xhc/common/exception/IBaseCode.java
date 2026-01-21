package com.xhc.common.exception;

import com.xhc.common.enums.LanguageEnum;
import org.springframework.http.HttpStatus;

/**
 * @author 80387245
 * @create 2023/10/7
 */
public interface IBaseCode {
    IErrorCode code();

    void setCode(IErrorCode code);

    String message(LanguageEnum language);

    void setMessage(String message, LanguageEnum language);

    HttpStatus responseStatus();

    void setResponseStatus(HttpStatus responseStatusCode);

    String getMessage(String name);

    Integer getCode(String name);

    IBaseCode getEnum(int code);
}
