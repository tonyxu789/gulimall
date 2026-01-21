package com.xhc.common.exception;

/**
 * @author 80387245
 * @create 2023/10/7
 */
public class PermissionForbiddenException extends BusinessBaseException{
    PermissionForbiddenException() {
        super();
    }

    PermissionForbiddenException(IBaseCode resultCode){
        super(resultCode);
    }

    PermissionForbiddenException(IBaseCode resultCode,Throwable cause) {
        super(resultCode,cause);
    }

}
