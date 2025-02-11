package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:36
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductProductSkuPricesEditDTO {
    //request.addApiParameter("product_id", "32985788417");
    //request.addApiParameter("sku_id_price_map", "{ \"14:193\": \"0.6\",\"14:175\": \"0.9\"}");
    private String product_id;
    private String sku_id_price_map;
}
