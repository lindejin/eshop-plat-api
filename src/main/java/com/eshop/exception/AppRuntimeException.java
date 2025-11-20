package com.eshop.exception;


public class AppRuntimeException extends RuntimeException {

    protected int code;
    protected Object data;

    public AppRuntimeException(String message) {
        super(message);
    }

    public AppRuntimeException(String message,int code) {
        super(message);
        setCode(code);
    }
    public AppRuntimeException(String message,Throwable cause) {
        super(message,cause);
    }
    public AppRuntimeException(String message,int code, Throwable cause) {
        super(message,cause);
        setCode(code);
    }

    public int getCode() {
        return code;
    }

    public AppRuntimeException setCode(int code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public AppRuntimeException setData(Object data) {
        this.data = data;
        return this;
    }

}

