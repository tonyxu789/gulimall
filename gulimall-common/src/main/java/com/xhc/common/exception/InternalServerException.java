package com.xhc.common.exception;

/**
 * @author 80387245
 * @create 2023/10/7
 */
public class InternalServerException extends BusinessBaseException{
    InternalServerException() {
        super();
    }

    InternalServerException(IBaseCode resultCode,Throwable cause) {
        super(resultCode,cause);
    }

    InternalServerException(IBaseCode resultCode){
        super(resultCode);
    }
}
