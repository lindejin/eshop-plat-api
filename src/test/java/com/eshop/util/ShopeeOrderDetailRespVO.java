package com.eshop.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ldj
 * @date 2024/3/18 10:32
 * @Description: ...
 * @Version 1.0
 */
@Setter
@Getter
public class ShopeeOrderDetailRespVO {
    //返回json数据
    private String respBody;

    /**
     * The identifier for an API request for error tracking.
     */
    private String request_id;

    /**
     * Indicate error type if hit error. Empty if no error happened.
     */
    private String error;

    /**
     * Indicate error details if hit error. Empty if no error happened.
     */
    private String message;

    /**
     * Detail informations you are querying.
     */
    private ShopeeOrderDetailResponse response;

    /**
     * Indicate warning message you should take care.
     */
    private List<String> warning;
}
