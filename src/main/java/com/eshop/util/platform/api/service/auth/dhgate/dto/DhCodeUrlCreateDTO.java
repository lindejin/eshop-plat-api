package com.eshop.util.platform.api.service.auth.dhgate.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/12 18:15
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class DhCodeUrlCreateDTO {

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
