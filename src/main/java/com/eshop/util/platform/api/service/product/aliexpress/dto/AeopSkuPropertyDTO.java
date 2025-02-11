package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 16:48
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopSkuPropertyDTO {
    //property_value_definition_name	String	否	属性自定义名称
    private String property_value_definition_name;
    //property_value_id	Number	否	属性值Id
    private Number property_value_id;
    //sku_image	String	否	sku自定义图片，女装类目色卡图。图片格式只允许jpg、png、jpeg这3种格式
    private String sku_image;
    //sku_property_id	Number	否	属性Id
    private Number sku_property_id;
    //image_url_list	String[]	否	女装类目sku套图,3:4图片,图片数量限制 : 3到6张图片。女装(200000345)下的叶子类目必传参数。图片格式只允许jpg、png、jpeg这3种格式
    private String[] image_url_list;
}
