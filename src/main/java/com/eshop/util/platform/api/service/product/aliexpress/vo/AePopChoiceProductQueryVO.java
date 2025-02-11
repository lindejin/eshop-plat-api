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
public class AePopChoiceProductQueryVO {

    // 该商品下已勾选参与的国家列表
    private List<String> joinedCountryList;
    // 该半托管商品下SKU列表
    private List<AePopChoiceProductSkuQueryRespVO> productSkuList;
    // 半托管商品id
    private Long productId;
    // 货币码
    private String currencyCode;
    // 类目id
    private Long categoryId;
}
