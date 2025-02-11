package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 15:55
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductBatchProductDeleteDTO {
    //request.addApiParameter("product_ids", "4000403362451,4000403362452");
    private String product_ids;
}
