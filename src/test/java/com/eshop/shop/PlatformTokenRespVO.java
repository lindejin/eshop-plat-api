package com.eshop.shop;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2023/10/27 14:07
 * @Description: 平台授权token返回VO
 * @Version 1.0
 */
@Getter
@Setter
public class PlatformTokenRespVO {

    /**
     * String	调用成功时返回，新的refresh_token，使用refresh_token去获取新的access_token
     */
    private String refreshToken;

    /**
     * String	调用成功时返回，新的access_token，动态令牌
     */
    private String accessToken;

    /**
     * Long	 调用成功时返回，access_token有效时间 单位毫秒
     */
    private Long expireIn;

    /**
     * Long access_token过期时间点 单位毫秒
     */
    private Long expireTime;

    /**
     * Long refresh_token有效时间 单位毫秒
     */
    private Long refreshIn;

    /**
     * Long refresh_token过期时间点 单位毫秒
     */
    private Long refreshTime;


    /**
     * erp店铺id
     */
    private Long shopId;


    /**
     * erp店铺类型
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

    /**
     * 返回respBody数据
     */
    private String respBody;
}
