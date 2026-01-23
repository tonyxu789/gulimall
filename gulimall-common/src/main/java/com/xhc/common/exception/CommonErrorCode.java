package com.xhc.common.exception;

import lombok.Getter;
import lombok.ToString;


/**
 * 自定义内部异常
 *
 * @author 80387245
 * @create 2022/11/10
 */
@Getter
@ToString
public enum CommonErrorCode implements IErrorCode {
    /* 枚举 */
    SUCCESS(1, "成功"),
    SUCCESS_NEW(0, "成功"),
    ERROR(501, "系统异常"),
    NOT_LOGIN(502, "用户未登陆"),
    SYSTEM_ERROR(504, "系统异常"),
    PARAM_ERROR(505, "参数 %s 异常"),
    DATA_BIND_ERROR(506, "数据绑定异常"),
    DATA_VALID_ERROR(507, "数据校验异常"),
    DATA_PARSE_ERROR(508, "数据转换异常"),
    DATA_TYPE_MISS_MATCH_ERROR(509, "数据类型匹配异常"),
    HTTP_METHOD_NOT_SUPPORT_ERROR(510, "HTTP请求方式 %s 不支持"),
    MISS_PARAM_ERROR(511, "缺少参数异常"),
    HTTP_MESSAGE_NOT_READABLE(512, "HTTP消息不能读取"),
    PARAM_ILLEGAL_ARGUMENT_ERROR(513, "非法参数 %s"),
    FEIGN_RESPONSE_FORMAT_ERROR(514, "Feign接口响应格式异常"),
    FEIGN_RESPONSE_ERROR(515, "Feign接口响应异常"),
    FEIGN_REQUEST_ERROR(516, "Feign接口请求异常"),
    FEIGN_RESPONSE_SYSTEM_ERROR(517, "Feign接口响应异常"),
    FEIGN_RESPONSE_STATUS_ERROR(518, "Feign接口响应状态异常"),
    FEIGN_RESPONSE_DECODE_ERROR(519, "Feign解码异常"),
    MESSAGE_CONFIG_MISS(520, "消息配置找不到"),
    MESSAGE_CONFIG_TOPIC_MISS(521, "消息配置主题找不到"),
    MESSAGE_BODY_MISS(522, "消息体找不到"),
    MESSAGE_CONSUMER_ERROR(523, "消息消费异常"),
    FEIGN_SERVER_ERROR(524, "feign 服务端异常"),
    FEIGN_INVOKE_ERROR(525, "feign调用异常: %s"),
    JWT_TOKEN_VERIFY_ERROR(526, "feign调用异常: %s"),
    REDIS_OPERATION_EXCEPTION(527, "redis操作异常: %s"),
    HTTPCLIENT_REQUEST_EXCEED_MAX_COUNT(528, "http client retry exceed max count"),
    INIT_HTTPCLIENT_FAIL(529, "init httpclient fail,reason: %s"),
    INVALID_HTTP_METHOD(530, "Invalid HTTP method: %s"),

    // 兼容历史
    FAILED_DEFAULT(10000, "失败"),

    /**
     * 参数不存在
     */
    PARAMETER_NOT_EXISTS_DEFAULT(10001, "参数不存在"),

    /**
     * 参数不在合适的范围
     */
    PARAMETER_IN_CORRECT_RANGE_DEFAULT(10002, "参数不再合适范围"),

    /**
     * 参数为空
     */
    PARAMETER_EMPTY_DEFAULT(10003, "参数为空"),

    /**
     * 参数类型不正确
     */
    PARAMETER_INCORRECT_TYPE_DEFAULT(10004, "参数类型不正确"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR_DEFAULT(10005, "服务器内部错误"),

    /**
     * 权限被拒绝
     */
    PERMISSION_DENIED_DEFAULT(10006, "权限被拒绝"),

    /**
     * 请求身份信息未找到
     */
    CERTIFICATION_NOT_FOUND_DEFAULT(10007, "请求身份信息未找到"),

    /**
     * 远程调用失败
     */
    REMOTE_ACCESS_ERROR_DEFAULT(10008, "远程调用失败"),

    /**
     *
     */
    HTTP_MESSAGE_NOT_READABLE_ERROR_DEFAULT(10009, "请求体缺失或者请求体的内容不能转换"),

    /**
     * 请求参数校验失败
     */
    REQUEST_PARAMETER_VALIDATION_FAILED_DEFAULT(10010, "请求参数校验失败");


    private final Integer code;

    private final String defaultMessage;

    CommonErrorCode(Integer code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

}