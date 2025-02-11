package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:26
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductCreateProductGroupDTO {
    //request.addApiParameter("name", "foo");
    private String name;
    //request.addApiParameter("parent_id", "100");
    private String parent_id;
}
