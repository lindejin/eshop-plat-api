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
public class AePopSkuPropertyDTO {
    // SKU属性值
    private String sku_property_value;

    //SKU属性值ID
    private Number property_value_id_long;

    // 女装类目SKU套图,3:4图片,图片数量限制 : 3到6张图片。女装(200000345)下的叶子类目必传参数
    private String[] image_url_list;

    // SKU属性名ID
    private Number sku_property_id_long;

    // SKU属性名称
    private String sku_property_name;

    // 属性值自定义名称
    private String property_value_definition_name;

    // SKU图片地址
    private String sku_image;
}
