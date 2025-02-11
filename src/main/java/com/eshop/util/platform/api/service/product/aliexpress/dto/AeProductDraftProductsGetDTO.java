package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:21
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductDraftProductsGetDTO {
    //request.addApiParameter("aeop_a_e_product_list_query", "{\"current_page\":\"2\",\"page_size\":\"30\"}");
    private String aeop_a_e_product_list_query;
}
