package com.eshop.util.platform.api.service.user.seller.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/17 15:34
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeGlobalSellerBrandsListDTO {
    //     request.addApiParameter("locale", "en_US");
    private String locale;
    //     request.addApiParameter("category_id", "62239238");
    private String category_id;
}
