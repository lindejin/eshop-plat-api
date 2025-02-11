package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:38
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductEditMultipleSkuStocksDTO {
    //request.addApiParameter("product_id", "32297192242");
    //request.addApiParameter("sku_stocks", "{\"14:200003699;5:100014064\":240, \"14:200003699;5:361386\": 220}");
    private String product_id;
    private String sku_stocks;
}
