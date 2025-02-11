package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:12
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductHsCodeQueryDTO {
    //request.addApiParameter("country_code", "TR");
    private String country_code;
    //request.addApiParameter("category_id", "5090301");
    private String category_id;

}
