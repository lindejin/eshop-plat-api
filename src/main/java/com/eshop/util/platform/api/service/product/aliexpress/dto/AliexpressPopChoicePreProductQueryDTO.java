package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/30 17:46
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AliexpressPopChoicePreProductQueryDTO {
    //request.addApiParameter("product_id", "1005005906923241");
    private String product_id;
    //request.addApiParameter("language", "zh_CN");
    private String language;
}
