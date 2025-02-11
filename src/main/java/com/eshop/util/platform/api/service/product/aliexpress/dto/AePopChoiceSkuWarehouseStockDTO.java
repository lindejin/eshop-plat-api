package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rch
 * @date 2024/3/2 16:28
 * @Description: 仓库库存信息
 * @Version 1.0
 */
@Getter
@Setter
public class AePopChoiceSkuWarehouseStockDTO {
    // 库存数量
    private Number sellable_quantity;

    //仓库编码
    private String warehouse_code;
}
