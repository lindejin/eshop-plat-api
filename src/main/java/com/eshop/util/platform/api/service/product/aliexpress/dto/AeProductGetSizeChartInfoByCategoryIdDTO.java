package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:32
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductGetSizeChartInfoByCategoryIdDTO {
    //request.addApiParameter("channel", "AE_GLOBAL");
    //request.addApiParameter("channel_seller_id", "2671514005");
    //request.addApiParameter("category_id", "348");
    private String channel;
    private String channel_seller_id;
    private String category_id;

}
