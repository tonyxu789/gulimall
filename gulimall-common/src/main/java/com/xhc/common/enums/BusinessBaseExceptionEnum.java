package com.xhc.common.enums;


import com.xhc.common.exception.*;

/**
 * @author 80387245
 * @create 2023/10/7
 */
public enum BusinessBaseExceptionEnum {

    /**
     * 内部服务错误
     */
    INTERNAL_SERVER_ERROR(InternalServerException.class,ResultCode.INTERNAL_SERVER_ERROR_DEFAULT),

    /**
     * 权限被拒绝
     */
    PERMISSION_FORBIDDEN_EXCEPTION(PermissionForbiddenException.class,ResultCode.PERMISSION_FORBIDDEN_EXCEPTION_DEFAULT),

    /**
     * 用户没有认证
     */
    CERTIFICATION_NOT_FOUND_EXCEPTION(CertificationException.class,ResultCode.CERTIFICATION_NOT_FOUND_EXCEPTION_DEFAULT),

    /**
     * RPC调用异常
     */
    REMOTE_ACCESS_EXCEPTION(RemoteAccessException.class,ResultCode.REMOTE_ACCESS_EXCEPTION_DEFAULT),
    ;

    private Class<? extends BusinessBaseException> eClass;
    private IBaseCode resultCode;

    public IBaseCode getResultCode() {
        return resultCode;
    }

    BusinessBaseExceptionEnum(Class<? extends BusinessBaseException> eClass, IBaseCode resultCode) {
        this.eClass = eClass;
        this.resultCode = resultCode;
    }

    public static BusinessBaseExceptionEnum getByEClass(Class<? extends BusinessBaseException> eClass) {
        if (eClass == null) {
            return null;
        }
        for (BusinessBaseExceptionEnum exceptionEnum : BusinessBaseExceptionEnum.values()) {
            if (eClass.equals(exceptionEnum.eClass)) {
                return exceptionEnum;
            }
        }
        return null;
    }

    public BusinessBaseException getExceptionInstance(){
        try{
            return this.eClass.newInstance();
        }catch(Exception e){
            e.printStackTrace();
            throw new IllegalStateException("通过反射获取异常类发生异常!");
        }
    }
}
