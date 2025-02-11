package com.eshop.util.platform.api.service.category.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 10:12
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeCategoryQualificationsListDTO {
//    request.addApiParameter("category_id", "200001426");
    private String category_id;
//    request.addApiParameter("local", "zh_CN");
    private String local;
}
