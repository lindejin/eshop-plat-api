package com.eshop.util.platform.api.service.product.aliexpress.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rch
 * @date 2024/4/2 11:22
 * @Description: 半托管商品新发第二段提交
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AePopChoiceProductDraftQuerySkuProPertyVO {
    // SKU属性值
    private String sku_property_value;

    // SKU属性值ID
    private Long property_value_id_long;

    // SKU属性名ID
    private Long sku_property_id_long;

    // SKU属性名称
    private String sku_property_name;

    // 属性值自定义名称
    private String property_value_definition_name;

    // 半托管编辑页面sku展示图片（取pop信息sku套图的首张图片信息）
    private String sku_image;
}
