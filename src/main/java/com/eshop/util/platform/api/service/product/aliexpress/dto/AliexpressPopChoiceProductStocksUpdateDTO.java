package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/30 17:45
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AliexpressPopChoiceProductStocksUpdateDTO {
    //request.addApiParameter("pop_choice_sku_stock_list", "[{\"sku_id\":\"123\",\"pop_choice_sku_warehouse_stock_list\":[{\"warehouse_code\":\"test-001JIT\",\"sellable_quantity\":\"100\"},{\"warehouse_code\":\"test-001JIT\",\"sellable_quantity\":\"100\"}]}]");
    private String pop_choice_sku_stock_list;
    //request.addApiParameter("product_id", "123");
    private String product_id;


}
