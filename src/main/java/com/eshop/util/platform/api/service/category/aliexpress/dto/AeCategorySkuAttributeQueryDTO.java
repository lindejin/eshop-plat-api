package com.eshop.util.platform.api.service.category.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 9:41
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeCategorySkuAttributeQueryDTO {
    //        request.addApiParameter("query_sku_attribute_info_request", "{\"category_id\":\"11112222\",\"aliexpress_category_id\":\"200000801\"}");
    private String query_sku_attribute_info_request;
}
