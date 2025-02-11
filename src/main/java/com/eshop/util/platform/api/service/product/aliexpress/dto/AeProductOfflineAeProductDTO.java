package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:35
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductOfflineAeProductDTO {
    //request.addApiParameter("edit_reason", "product_diagnosis");
    //request.addApiParameter("product_ids", "109827;109828");
    private String edit_reason;
    private String product_ids;
}
