package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:56
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductCopySizeTemplateDTO {
    //request.addApiParameter("size_template_id", "1");
    //request.addApiParameter("target_leaf_id", "364");
    private String size_template_id;
    private String target_leaf_id;
}
