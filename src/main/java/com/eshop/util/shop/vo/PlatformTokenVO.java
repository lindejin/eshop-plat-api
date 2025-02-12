package com.eshop.util.shop;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/14 13:45
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class PlatformTokenVO {

    /**
     * erp店铺id
     */
    private Long shopId;

    /**
     * String	调用成功时返回，新的refresh_token，使用refresh_token去获取新的access_token
     */
    private String refreshToken;

    /**
     * String	调用成功时返回，新的access_token，动态令牌
     */
    private String accessToken;
}
