package com.eshop.shop;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/13 10:21
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class PlatformTokenRefreshDTO {

    /**
     * 平台code
     */
    private String platformCode;

    /**
     * 调用参数_静态_空值
     */
    private String paramStaticJson;

    /**
     * erp店铺id
     */
    private Long shopId;

    /**
     * 店铺类型
     */
    private Integer shopType;

    /**
     * 平台主账户id
     */
    private String platMainAccountId;

    /**
     * 平台主账户商户id
     */
    private String platMerchantId;

    /**
     * 平台店铺id
     */
    private String platShopId;

    /**
     * 操作人id
     */
    private Long opId;

    private String refreshToken;
}
