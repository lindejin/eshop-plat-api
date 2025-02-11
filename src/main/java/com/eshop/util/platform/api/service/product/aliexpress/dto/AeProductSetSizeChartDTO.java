package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:19
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductSetSizeChartDTO {
    //request.addApiParameter("channel_seller_id", "2671514005");
    private String channel_seller_id;
    //request.addApiParameter("channel", "AE_GLOBAL");
    private String channel;
    //request.addApiParameter("product_id", "1005005100110934");
    private String product_id;
    //request.addApiParameter("sizechart_id", "1000001533573010");
    private String sizechart_id;
}
