package com.eshop.util.platform.api.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * api业务异常类
 *
 * @author ldj
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiSyncException extends RuntimeException {

    private static final long serialVersionUID = 3447728300174142127L;

    /**
     * 异常消息
     */
    private String msg;

    public ApiSyncException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ApiSyncException(String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }
}
