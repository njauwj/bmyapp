package com.wj.bmyapp.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {


    private String msg;

    public BusinessException(BusinessExceptionEnum e) {

        msg = e.getDesc();
    }

    public BusinessException(String message) {
        msg = message;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
