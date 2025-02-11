package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:06
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductQueryBundleDTO {
    //request.addApiParameter("param_aeop_offer_bundle_query_condition", "{\"item_subject\":\"test-product\",\"item_id\":\"32840310226\",\"current_page\":\"1\",\"page_size\":\"10\"}");
    private String param_aeop_offer_bundle_query_condition;
}
