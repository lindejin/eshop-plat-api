package com.eshop.util.platform.api.service.auth.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/12 17:56
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeCodeUrlCreateDTO {
    private String responseType;
    private String forceAuth;
    private String clientId;
    private String state;
    private String uuid;

    /**
     * 回调地址 url
     */
    private String redirectUrl;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 操作人id
     */
    private Long opId;
}
