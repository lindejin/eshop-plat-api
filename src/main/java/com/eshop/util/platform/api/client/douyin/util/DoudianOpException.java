//package com.eshop.util.platform.api.client.douyin.util;
//
//
//
//public class DoudianOpException extends RuntimeException {
//    private Code code;
//
//    public enum Code {
//
//        int code;
//
//        String message;
//
//        Code(int code, String message) {
//            this.code = code;
//            this.message = message;
//        }
//        }
//
//    public Code getCode() {
//        return this.code;
//    }
//
//    public DoudianOpException(Code code) {
//        super(code.message);
//        this.code = code;
//    }
//
//    public DoudianOpException(Code code, String info) {
//        super(String.format("code.message: %s, info: %s", new Object[] { code.message, info }));
//        this.code = code;
//    }
//
//    public DoudianOpException(Exception e) {
//        super(e);
//        this.code = Code.UNRECOGNIZED_EXCEPTION;
//    }
//
//    public DoudianOpException(Code code, Exception e) {
//        super(e);
//        this.code = code;
//    }
//}
