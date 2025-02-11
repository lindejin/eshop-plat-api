package com.eshop.util.platform.api.service.category.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 10:09
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeCategoryGetChildAttributesResultByPostCateIdAndPathDTO {
    //    request.addApiParameter("channel", "AE_GLOBAL");
    private String channel;
    //    request.addApiParameter("locale", "en_US");
    private String locale;
    //    request.addApiParameter("product_type", "2");
    private String product_type;
    //    request.addApiParameter("channel_seller_id", "2671514005");
    private String channel_seller_id;
    //    request.addApiParameter("param1", "349");
    private String param1;
    //    request.addApiParameter("param2", "219=9441741844");
    private String param2;
}
