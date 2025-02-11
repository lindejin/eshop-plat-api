package com.eshop.util.platform.api.structure.shopee.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/6 11:39
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class ShopeeAppClientDTO {

    private String url;

    private String partnerId;
    private String partnerKey;

    private String accessToken;
    private String refreshToken;


    /**
     * 平台店铺id
     */
    private String platformShopId;


    /**
     * 请求地址
     */
    public final static String URL = "https://partner.shopeemobile.com";

    /**
     * 请求地址(中国大陆)
     */
    public final static String UR_CHINESE = "https://openplatform.shopee.cn";


    public String getUrl() {
        return UR_CHINESE;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
