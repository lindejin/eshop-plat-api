package com.eshop.exception;

/**
 * 业务异常类
 */
public class BusinessException extends RuntimeException {
    private final String code;
    private final String message;

    public BusinessException(String message) {
        this("500", message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message, Throwable cause) {
        this("500", message, cause);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    // Getters
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}