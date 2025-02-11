package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:48
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductGetSizeTemplatesByCategoryIdDTO {
    //request.addApiParameter("channel_seller_id", "2671514005");
    //request.addApiParameter("channel", "AE_GLOBAL");
    //request.addApiParameter("leaf_category_id", "348");
    //request.addApiParameter("current_page", "1");
    private String channel_seller_id;
    private String channel;
    private String leaf_category_id;
    private String current_page;

}
