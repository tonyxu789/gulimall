package com.xhc.common.exception;

/**
 * @author 80387245
 * @create 2023/10/7
 */
public class RemoteAccessException extends BusinessBaseException{
    RemoteAccessException() {
        super();
    }

    RemoteAccessException(IBaseCode resultCode){
        super(resultCode);
    }

    RemoteAccessException(IBaseCode resultCode,Throwable cause) {
        super(resultCode,cause);
    }
}
