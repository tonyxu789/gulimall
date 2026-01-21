package com.xhc.common.exception;

import com.xhc.common.enums.LanguageEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

/**
 * @author 80387245
 * @create 2023/10/7
 */
@Slf4j
public class ResultCodeTemplate implements IBaseCode {
    private IErrorCode code;
    private HttpStatus responseStatus;
    private String messageZh;
    private String messageEn;

    public ResultCodeTemplate(IErrorCode code, HttpStatus responseStatus, String messageZh, String messageEn) {
        Assert.notNull(code, "ErrorCode object can not be null");
        this.code = code;
        this.responseStatus = responseStatus;
        this.messageEn = messageEn;
        this.messageZh = messageZh;
    }

    @Override
    public IErrorCode code() {
        return this.code;
    }

    @Override
    public void setCode(IErrorCode code) {
        Assert.notNull(code, "ErrorCode object can not be null");
        this.code = code;
    }

    @Override
    public String message(LanguageEnum language) {
        if (LanguageEnum.LANGUAGE_EN_US.equals(language)) {
            return messageEn;
        }
        if (LanguageEnum.LANGUAGE_ZH_CN.equals(language)) {
            return messageZh;
        }
        log.warn("No such supported language:{},return Chinese by default", language);
        return messageZh;
    }

    @Override
    public void setMessage(String message, LanguageEnum language) {
        if (LanguageEnum.LANGUAGE_EN_US.equals(language)) {
            this.messageEn = message;
        } else if (LanguageEnum.LANGUAGE_ZH_CN.equals(language)) {
            this.messageZh = message;
        } else {
            throw new IllegalStateException("No such supported language:" + language);
        }
    }

    @Override
    public HttpStatus responseStatus() {
        return this.responseStatus;
    }

    @Override
    public void setResponseStatus(HttpStatus responseStatusCode) {
        this.responseStatus = responseStatusCode;
    }

    @Override
    public String getMessage(String name) {
        return null;
    }

    @Override
    public Integer getCode(String name) {
        return null;
    }

    @Override
    public IBaseCode getEnum(int code) {
        return null;
    }
}
