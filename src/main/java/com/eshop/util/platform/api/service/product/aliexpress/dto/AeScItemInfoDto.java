package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName AeScItemInfoDto
 * @Description 货品信息对象
 * @Author xxs
 * @Date 2024/6/25 14:10
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeScItemInfoDto {
//    can_edit_bar_code	Boolean	货品条码是否可以编辑
    private Boolean can_edit_bar_code;
//    sc_item_code	String	货品编码
    private String sc_item_code;
//    sc_item_bar_code	String	货品条码
    private String sc_item_bar_code;
//    special_product_type_list	String[]	物流属性，特殊商品类型： 内电 ：274526 ， 弱磁 ： 274452
    private List<String> special_product_type_list;
//    sc_item_id	Number	sku绑定的货品id
    private Long sc_item_id;
//    original_box	String	是否原箱： 1 是， 0 不是
    private String original_box;
}
