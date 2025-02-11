package com.eshop.util.platform.api.service.product.aliexpress.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rch
 * @date 2024/4/2 11:22
 * @Description: SKU货品信息
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AePopChoiceProductSkuScItemInfoRespVO {
    // SKU货品编码
    private String scItemCode;
    // SKU货品id
    private Long scItemId;

    // 是否原箱，0否1是
    private String originalBox;

    // TODO 还有好些 暂时用不到先不写
}
