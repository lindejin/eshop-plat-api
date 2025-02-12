package com.eshop.util.shop.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/14 9:27
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class PlatformMerchantTokenRedisVO {

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
    private Long shopMerchantId;
}
