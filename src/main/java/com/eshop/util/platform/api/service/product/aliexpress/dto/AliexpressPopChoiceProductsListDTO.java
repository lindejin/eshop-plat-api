package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ldj
 * @date 2024/3/30 17:48
 * @Description: ...
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliexpressPopChoiceProductsListDTO {
    //request.addApiParameter("param", "{\"leaf_category\":\"579\",\"gmt_modified_end\":\"2012-01-01 12:13:14\",\"gmt_modified_start\":\"2012-01-01 12:13:14\",\"product_id\":\"10000000000\",\"joined_product_tab\":\"joined\",\"current_page\":\"1\",\"page_size\":\"20\"}");
    // private String param;

    private String leaf_category;

    private String gmt_modified_end;

    private String gmt_modified_start;

    private String product_id;

    private String joined_product_tab;

    private String current_page;

    private String page_size;

    private Long shop_id;
}
