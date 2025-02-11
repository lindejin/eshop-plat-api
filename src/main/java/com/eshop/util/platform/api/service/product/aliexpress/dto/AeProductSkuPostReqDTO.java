package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName AeProductSkuPostReqDTO
 * @Description sku列表
 * @Author xxs
 * @Date 2024/6/25 14:04
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeProductSkuPostReqDTO {
//    supply_price	String	是	sku供货价
    private String supply_price;
//    sku_property_list	Object[]	否	Sku属性对象list，允许1-3个sku属性对象，按sku属性顺序排放。sku属性从类目属性接口getAttributesResultByCateId获取。该项值输入sku属性，不能输入普通类目属性。
    private List<AeSkuPropertyPostReqDTO> sku_property_list;
//    sku_code	String	否	Sku商家编码，新发对应货品编码。当货品编码已经存在时，需要保证填写的货品条码与存在货品的货品编码保持相同。新发商品会自动绑定到已经存在的货品上
    private String sku_code;
//    status	String	否	sku的状态 ，是否销售，active ：销售 ； inactive ：不销售
    private String status;
//    package_weight	String	是	sku 级别重量，KG，请做好必填校验
    private String package_weight;
//    package_height	String	是	sku级别 高度。cm，请做好必填校验
    private String package_height;
//    package_width	String	是	sku级别 宽度。cm，请做好必填校验
    private String package_width;
//    package_length	String	是	sku级别 长度。cm，请做好必填校验
    private String package_length;
//    sc_item_info_dto	Object	否	货品信息对象
    private AeScItemInfoDto sc_item_info_dto;
//    warehouse_list	Object[]	否	库存列表
    private List<AeWarehousePostReqDTO> warehouse_list;
}
