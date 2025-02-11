package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:37
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductSetGroupsDTO {
    //request.addApiParameter("product_id", "1005005270241178");
    //request.addApiParameter("group_ids", "254562048");
    private String product_id;
    private String group_ids;
}
