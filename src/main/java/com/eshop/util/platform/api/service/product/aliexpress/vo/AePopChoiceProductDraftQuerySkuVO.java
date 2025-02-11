package com.eshop.util.platform.api.service.product.aliexpress.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author rch
 * @date 2024/4/2 11:22
 * @Description: 半托管商品新发第二段提交
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AePopChoiceProductDraftQuerySkuVO {
    private String skuId;
    private String skuCode;
    private List<AePopChoiceProductDraftQuerySkuProPertyVO> skuPropertyList;
}
