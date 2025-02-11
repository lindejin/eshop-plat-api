package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName AeProductExtPostReqDTO
 * @Description 扩展信息
 * @Author xxs
 * @Date 2024/6/25 14:18
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeProductExtPostReqDTO {
//    aeop_qualification_struct_list	Object[]	否	资质信息
    private List<AeopQualificationStructDTO> aeop_qualification_struct_list;
//    special_product_type_list	String[]	否	特殊商品类型，目前只支持两种类型的商品发布 ：弱磁 ：240003 ； 内电 ：239818
    private String[] special_product_type_list;
//    msr_eu_id	Number	否	欧盟责任人id，需要调用查询欧盟责任人列表接口：aliexpress.category.eu.responsible.persons.list，获取对应的欧盟责任人列表
    private Number msr_eu_id;
//    size_chart_id	Number	否	产品所关联的尺码模版ID
    private Number size_chart_id;
//    product_type	String	是	全托管商品备货类型， 仓发：0 ； 即时补货（JIT）：1 ； 海外备仓：2 。
    private String product_type;
//    size_chart_id_list	Number[]	否	产品所关联的尺码模版ID列表
    private Number[] size_chart_id_list;
}
