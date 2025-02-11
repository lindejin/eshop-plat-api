package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/30 17:47
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AliexpressPopChoiceCollectedProductsListDTO {
    //request.addApiParameter("param", "{\"leaf_category\":\"579\",\"product_id\":\"10000000000\",\"current_page\":\"1\",\"page_size\":\"20\"}");
    private String param;
}
