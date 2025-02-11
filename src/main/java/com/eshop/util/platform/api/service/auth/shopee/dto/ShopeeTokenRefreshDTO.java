package com.eshop.util.platform.api.service.auth.shopee.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/12 17:37
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class ShopeeTokenRefreshDTO {
    //Name	Type	Required	Sample	Description
    //refresh_token	string	True		Use refresh_token to get a new access_token. Each refresh_token is valid for 30 days, and can only be used once by either a shop_id or merchant_id.
    private String refreshToken;
    //partner_id	int	True		The partner_id obtained from the App. This partner_id is inserted into the body.
    private String partnerId;
    //shop_id	int	False		The shop_id of the main account that granted authorization to your App. Only the shop_id or merchant_id can be selected as the input parameter, and they must be refreshed separately.
    private String shopId;
    //merchant_id	int	False		The merchant_id for identifying the main account that granted authorization to your App. Only the shop_id or merchant_id can be selected as the input parameter, and they must be refreshed separately.
    private String merchantId;

    private Integer shopType;
}
