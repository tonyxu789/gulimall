package com.xhc.common.enums;

import com.xhc.common.exception.CommonErrorCode;
import com.xhc.common.exception.IBaseCode;
import com.xhc.common.exception.IErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

/**
 * @author 80387245
 * @create 2023/10/7
 */
@Slf4j
public enum ResultCode implements IBaseCode {
    /* 成功状态码 */
    SUCCESS(CommonErrorCode.SUCCESS, "success", "成功", HttpStatus.OK),

    /* 失败状态码，一般不用 */
    FAILED(CommonErrorCode.FAILED_DEFAULT, "failed", "失败", null),

    TEMPLATE_XXX_IS_NOT_EXISTS(CommonErrorCode.PARAMETER_NOT_EXISTS_DEFAULT, "Parameter with the name:{0} hasn't been existed,check your request parameters please!", "名称为：{0} 的参数不存在，请检查请求参数", HttpStatus.BAD_REQUEST),

    TEMPLATE_XXX_IS_IN_BAD_RANGE(CommonErrorCode.PARAMETER_IN_CORRECT_RANGE_DEFAULT, "Parameter with the name:{0} is in the incorrect range,required range is:{1}", "名称为：{0} 的参数不在期望的范围内，正确的范围是：{1}", HttpStatus.BAD_REQUEST),

    TEMPLATE_XXX_IS_EMPTY(CommonErrorCode.PARAMETER_EMPTY_DEFAULT, "Parameter with the name:{0} can not be empty", "名称为：{0}的参数不能为空", HttpStatus.BAD_REQUEST),

    TEMPLATE_XXX_TYPE_ERROR(CommonErrorCode.PARAMETER_INCORRECT_TYPE_DEFAULT, "Type of the parameter with the name:{0} is {1},which is incorrect,it should be:{2}", "名称为：{0}的参数的数据类型（{1}）是不正确的，正确的类型是：{2}", HttpStatus.BAD_REQUEST),

    TEMPLATE_INTERNAL_SERVER_ERROR(CommonErrorCode.INTERNAL_SERVER_ERROR_DEFAULT, "An internal server error has been encountered in the {0} service,Please contact the technical support for help", "{0}服务内部服务错误,请联系技术支持", HttpStatus.INTERNAL_SERVER_ERROR),

    INTERNAL_SERVER_ERROR_DEFAULT(CommonErrorCode.INTERNAL_SERVER_ERROR_DEFAULT, "Internal server error,Please contact the technical support", "内部服务错误,请联系技术支持", HttpStatus.INTERNAL_SERVER_ERROR),

    PERMISSION_FORBIDDEN_EXCEPTION_DEFAULT(CommonErrorCode.PERMISSION_DENIED_DEFAULT, "This operation of the current user is denied，Please contact the technical support for help", "当前用户的操作被拒绝,请联系技术支持", HttpStatus.FORBIDDEN),

    TEMPLATE_PERMISSION_FORBIDDEN_EXCEPTION_DEFAULT(CommonErrorCode.PERMISSION_DENIED_DEFAULT, "This operation ({0}) of the current user is denied，Please contact the technical support for help", "当前用户的操作({0})被拒绝,请联系技术支持", HttpStatus.FORBIDDEN),

    CERTIFICATION_NOT_FOUND_EXCEPTION_DEFAULT(CommonErrorCode.CERTIFICATION_NOT_FOUND_DEFAULT, "This Certification Information of the current user is not found", "当前用户的身份信息未找到", HttpStatus.UNAUTHORIZED),

    REMOTE_ACCESS_EXCEPTION_DEFAULT(CommonErrorCode.REMOTE_ACCESS_ERROR_DEFAULT, "Remote process call has encountered an error", "远程过程调用错误", HttpStatus.INTERNAL_SERVER_ERROR),

    HTTP_MESSAGE_NOT_READABLE_EXCEPTION_DEFAULT(CommonErrorCode.HTTP_MESSAGE_NOT_READABLE_ERROR_DEFAULT, "The request body is missing or is can not be convert to a required Json Object,Please check your request body", "请求体缺失或者请求体的内容不能转换成所需要的JSON对象，请检查请求体参数", HttpStatus.BAD_REQUEST),

    REQUEST_PARAMETER_VALIDATION_FAILED_EXCEPTION_DEFAULT(CommonErrorCode.REQUEST_PARAMETER_VALIDATION_FAILED_DEFAULT, "The validation of request parameters has failed,Please check your request parameters", "请求参数校验失败，请检查请求参数合法性", HttpStatus.BAD_REQUEST),
    ;
    private IErrorCode code;
    private HttpStatus responseStatus;
    private String messageZh;
    private String messageEn;

    ResultCode(IErrorCode code, String messageEn, String messageZh, HttpStatus responseStatus) {
        Assert.notNull(code, "ErrorCode object can not be null");
        this.code = code;
        this.messageZh = messageZh;
        this.messageEn = messageEn;
        this.responseStatus = responseStatus;
    }

    @Override
    public IErrorCode code() {
        return this.code;
    }

    @Override
    public void setCode(IErrorCode code) {
        log.warn("不建议修改枚举常量的值");
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
        log.warn("不建议修改枚举常量的值");
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
        return name;
    }

    @Override
    public Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code.getCode();
            }
        }
        return null;
    }


    @Override
    public IBaseCode getEnum(int code) {
        for (ResultCode ele : ResultCode.values()) {
            if (ele.code().getCode() == code) {
                return ele;
            }
        }
        return null;
    }

}
