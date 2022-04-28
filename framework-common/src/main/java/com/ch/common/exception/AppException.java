package com.ch.common.exception;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 10:13 2022/4/27
 * @Modified By :
 **/
public class AppException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public AppException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
