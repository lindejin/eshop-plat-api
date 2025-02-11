package com.eshop.util.platform.api.service.auth.shopee.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/12 17:51
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class ShopeeCodeUrlCreateDTO {

    /**
     * 回调地址 http url
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
