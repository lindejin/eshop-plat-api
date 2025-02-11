package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:39
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductEditSingleSkuPriceDTO {
    //request.addApiParameter("product_id", "123456789");
    //request.addApiParameter("sku_id", "14:771;5:100014066");
    //request.addApiParameter("sku_price", "999");
    //request.addApiParameter("sale_price", "999");
    private String product_id;
    private String sku_id;
    private String sku_price;
    private String sale_price;
}
