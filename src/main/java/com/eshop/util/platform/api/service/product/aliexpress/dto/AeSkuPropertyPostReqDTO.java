package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AeSkuPropertyPostReqDTO
 * @Description Sku属性对象list，允许1-3个sku属性对象，按sku属性顺序排放。sku属性从类目属性接口getAttributesResultByCateId获取。该项值输入sku属性，不能输入普通类目属性。
 * @Author xxs
 * @Date 2024/6/25 14:07
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeSkuPropertyPostReqDTO {
//    sku_property_value	String	否	销售属性值
    private String sku_property_value;
//    image_url_list	String[]	否	无效字段，全托管商品已经停止使用，不需要传。女装类目sku套图,3:4图片,图片数量限制 : 3到6张图片。女装(200000345)下的叶子类目必传参数
    private String[] image_url_list;
//    property_value_id	Number	否	销售属性值id
    private Number property_value_id;
//    sku_property_name	String	否	销售属性名
    private String sku_property_name;
//    sku_property_id	Number	否	销售属性id
    private Number sku_property_id;
//    property_value_definition_name	String	否	销售属性别名
    private String property_value_definition_name;
//    sku_image	String	否	sku图片
    private String sku_image;
}
