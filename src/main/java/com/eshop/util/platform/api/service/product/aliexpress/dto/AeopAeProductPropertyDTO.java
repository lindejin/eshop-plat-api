package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/2 16:43
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeProductPropertyDTO {
    //attr_name	String	否	属性名称
    private String attr_name;
    //attr_name_id	Number	否	属性名Id
    private Number attr_name_id;
    //attr_value	String	否	属性值
    private String attr_value;
    //attr_value_end	String	否	属性值区间结束
    private String attr_value_end;
    //attr_value_id	Number	否	属性值Id
    private Number attr_value_id;
    //attr_value_start	String	否	属性值区间开始
    private String attr_value_start;
    //attr_value_unit	String	否	属性值单位
    private String attr_value_unit;
}
