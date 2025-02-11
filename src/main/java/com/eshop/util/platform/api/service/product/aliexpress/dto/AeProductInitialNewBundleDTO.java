package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:53
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductInitialNewBundleDTO {
    //request.addApiParameter("main_item_id", "32840310226");
    //request.addApiParameter("sub_item_list", "[32829102949]");
    private String main_item_id;
    private String sub_item_list;
}
