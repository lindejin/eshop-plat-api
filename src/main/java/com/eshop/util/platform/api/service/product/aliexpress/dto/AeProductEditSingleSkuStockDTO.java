package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:41
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductEditSingleSkuStockDTO {
    //request.addApiParameter("product_id", "32297192242");
    //request.addApiParameter("sku_id", "14:200003699;5:100014065");
    //request.addApiParameter("ipm_sku_stock", "299");
    private String product_id;
    private String sku_id;
    private String ipm_sku_stock;
}
