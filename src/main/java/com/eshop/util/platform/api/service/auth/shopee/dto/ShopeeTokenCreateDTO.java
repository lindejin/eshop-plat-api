package com.eshop.util.platform.api.service.auth.shopee.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/12 17:36
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class ShopeeTokenCreateDTO {
    //Name	Type	Required	Sample	Description
    //code	string	True		The code in redirect url after the authorization. Valid for one-time use, expires in 10 minutes
    private String code;
    //partner_id	int	True		Partner ID is assigned upon registration is successful. Required for all requests.
//    private String partnerId;
    //shop_id	int	False		Shopee's unique identifier for a shop. Required param for most APIs.
    private String shopId;
    //main_account_id	int	False		The main_account_id of the seller that authorized the developer
    private String mainAccountId;


    private Integer shopType;
}
