package com.xhc.common.exception;

/**
 * @author 80387245
 * @create 2023/10/7
 */
public class CertificationException extends BusinessBaseException{

    CertificationException() {
        super();
    }

    CertificationException(IBaseCode resultCode,Throwable cause) {
        super(resultCode,cause);
    }

    CertificationException(IBaseCode resultCode){
        super(resultCode);
    }
}
