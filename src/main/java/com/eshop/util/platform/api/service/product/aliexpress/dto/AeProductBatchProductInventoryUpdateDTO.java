package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 15:59
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductBatchProductInventoryUpdateDTO {
    //        request.addApiParameter("mutiple_product_update_list", "[{\"product_id\":\"1000005237852\",\"multiple_sku_update_list\":[{\"inventory\":\"99\",\"sku_code\":\"123abc\"},{\"inventory\":\"99\",\"sku_code\":\"123abc\"}]}]");
    private String mutiple_product_update_list;
}
