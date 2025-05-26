package com.eshop.order;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Tk异常定义
 *
 * @author ldj
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TkException extends RuntimeException {

    /**
     * 异常消息
     */
    private String msg;

    public TkException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public TkException(String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }
}
