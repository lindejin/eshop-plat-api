package com.eshop.entity.base;

import lombok.Data;

@Data
public class ShopContextVO {

    /**
     * 平台_id
     */
    private Long platformId;

    /**
     * 平台_名称
     */
    private Long platformName;

    /**
     * 店铺_id
     */
    private Long shopId;

    /**
     * 店铺_名称
     */
    private Long shopName;

    /**
     * 店铺商户_id
     */
    private Long merchantId;


    /**
     * 店铺商户_名称
     */
    private String merchantName;

    /**
     * 店铺_区域
     */
    private String shopLocation;
}
