package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:01
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductCarModelFindByTecIdsDTO {
    //        request.addApiParameter("param", "{\"link_target_id_list\":[\"[]\",\"[]\"],\"current\":\"1\",\"year_id\":\"1\",\"model_id\":\"1\",\"country_id\":\"1\",\"brand_id\":\"1\",\"page_size\":\"10\"}");
    private String param;
}
