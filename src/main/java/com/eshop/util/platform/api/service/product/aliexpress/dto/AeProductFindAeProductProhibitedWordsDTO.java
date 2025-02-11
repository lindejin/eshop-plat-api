package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:54
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductFindAeProductProhibitedWordsDTO {
    //request.addApiParameter("category_id", "322");
    //request.addApiParameter("title", "nike");
    //request.addApiParameter("keywords", "0");
    //request.addApiParameter("product_properties", "0");
    //request.addApiParameter("detail", "This is a test for the product.");
    private String category_id;
    private String title;
    private String keywords;
    private String product_properties;
    private String detail;
}
