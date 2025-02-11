package com.eshop.util.platform.api.service.category.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 9:49
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeCategorySellerCategoryTreeQueryDTO {
//    request.addApiParameter("category_id", "509");
    private String category_id;
//    request.addApiParameter("filter_no_permission", "true");\
    private String filter_no_permission;
}
