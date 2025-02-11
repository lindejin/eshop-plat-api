package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author rch
 * @date 2024/3/2 16:28
 * @Description: 该半托管商品下SKU列表
 * @Version 1.0
 */
@Getter
@Setter
public class AePopProductSkuListDTO {
    //货品信息
    private AePopChoiceProductSkuScItemDTO pop_choice_product_sku_sc_item_info;

    // SKU物流尺寸-高，单位cm
    private String package_height;

    // 仓库库存信息
    private List<AePopChoiceSkuWarehouseStockDTO> pop_choice_sku_warehouse_stock_list;

    // SKU属性列表 sku_property_list
    private List<AePopSkuPropertyDTO> sku_property_list;

    // SKU级别重量，KG
    private String package_weight;

    // SKU物流尺寸-宽，单位cm
    private String package_width;

    //SKU物流尺寸-长，单位cm
    private String package_length;

    //SkuId，平台生成的唯一性随机数
    private String sku_id;

    // Sku商家编码。 格式:半角英数字,长度20,不包含空格大于号和小于号。如果用户只填写零售价（productprice）和商品编码，需要完整生成一条SKU记录提交，否则商品编码无法保存。系统会认为只提交了零售价，而没有SKU，导致商品编辑未保存。
    private String sku_code;

    // SKU裸价,不包含物流费
    private String base_price;
}
