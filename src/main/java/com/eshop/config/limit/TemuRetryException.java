package com.eshop.config.limit;

// 自定义异常类
public class TemuRetryException extends RuntimeException {
    public TemuRetryException(String message) {
        super(message);
    }
}
