package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:45
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductEditProductCategoryAttributesDTO {
    //request.addApiParameter("product_id", "1706468951");
    //request.addApiParameter("product_category_attributes", "[{\"attr_name_id\":\"0\",\"attr_name\":\"0\",\"attr_value_id\":\"0\",\"attr_value_unit\":\"0\",\"attr_value\":\"0\",\"attr_value_end\":\"0\",\"attr_value_start\":\"0\"}]");
    private String product_id;
    private String product_category_attributes;
}
