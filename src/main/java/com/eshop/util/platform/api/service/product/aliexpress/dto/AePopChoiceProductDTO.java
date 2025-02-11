package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author rch
 * @date 2024/3/2 16:28
 * @Description: 半托管商品新发第二段提交
 * @Version 1.0
 */
@Getter
@Setter
public class AePopChoiceProductDTO {
    // 该商品下已勾选参与的国家列表
    private String[] joined_country_list;

    // 该半托管商品下SKU列表 product_sku_list
    private List<AePopProductSkuListDTO> product_sku_list;

    // 商品id
    private String draft_id;

    // 货币码
    private String currency_code;

    // 类目id
    private String category_id;
}
