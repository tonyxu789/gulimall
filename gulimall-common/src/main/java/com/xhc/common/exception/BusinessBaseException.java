package com.xhc.common.exception;

import com.xhc.common.enums.BusinessBaseExceptionEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 80387245
 * @create 2023/10/7
 */
@Slf4j
public class BusinessBaseException extends RuntimeException{
    private static final long serialVersionUID = 194906846739586856L;

    protected IBaseCode resultCode;

    protected Object additionalData;

    protected String additionalNotes;

    public BusinessBaseException(){
        BusinessBaseExceptionEnum exceptionEnum = BusinessBaseExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum != null) {
            resultCode = exceptionEnum.getResultCode();
        }
    }

    public BusinessBaseException (IBaseCode resultCode,Throwable cause){
        super(cause);
        setResultCode(resultCode);
    }
    public BusinessBaseException(IBaseCode resultCode) {
        setResultCode(resultCode);
    }

    public IBaseCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(IBaseCode resultCode) {
        if(resultCode==null){
            log.warn("resultCode不建议为null");
        }
        this.resultCode = resultCode;
    }

    public Object getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Object additionalData) {
        this.additionalData = additionalData;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public void setAdditionalNotesWithFormat(String format, Object... objects){
        this.additionalNotes = String.format(format,objects);
    }
}
