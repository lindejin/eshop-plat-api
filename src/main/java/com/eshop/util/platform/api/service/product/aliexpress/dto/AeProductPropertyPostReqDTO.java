package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName AeProductPropertyPostReqDTO
 * @Description 商品属性列表
 * @Author xxs
 * @Date 2024/6/25 14:29
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeProductPropertyPostReqDTO {

//    attr_value_start	String	否	属性值区间开始
    private String attr_value_start;
//    attr_value_id	Number	否	属性值id
    private Number attr_value_id;
//    attr_value_end	String	否	属性值区间结束
    private String attr_value_end;
//    attr_value	String	否	属性值名称
    private String attr_value;
//    attr_value_unit	String	否	属性单位
    private String attr_value_unit;
//    attr_name	String	否	属性名称
    private String attr_name;
//    attr_name_id	Number	否	属性id
    private Number attr_name_id;
}
