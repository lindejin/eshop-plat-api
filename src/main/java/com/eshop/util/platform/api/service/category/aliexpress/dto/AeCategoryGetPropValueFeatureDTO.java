package com.eshop.util.platform.api.service.category.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/27 17:09
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeCategoryGetPropValueFeatureDTO {
    //    request.addApiParameter("propertyId", "1111");
    //    request.addApiParameter("valueId", "2222");
    //    request.addApiParameter("featureKey", "CountryCode");
    private String propertyId;
    private String valueId;
    private String featureKey;
}
