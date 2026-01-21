package com.xhc.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常占位符替换
 *
 * @author 80387245
 * @create 2022/11/10
 */
public interface IErrorCode {

    Logger LOG = LoggerFactory.getLogger(IErrorCode.class);

    /**
     * 4
     *
     * @return 错误码
     */
    Integer getCode();

    /**
     * 默认消息-支付站位符
     *
     * @return 默认信息
     */
    String getDefaultMessage();

    default String getCodeContent(Object... args) {
        if (null == args || 0 == args.length) {
            return getDefaultMessage();
        }
        try {
            return String.format(getDefaultMessage(), args);
        } catch (Throwable throwable) {
            LOG.warn("", throwable);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Format Error Message Error : {}, Args : {}", getDefaultMessage(), args);
            }
            return getDefaultMessage();
        }
    }
}