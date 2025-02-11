package com.eshop.util.platform.api.service.product.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ldj
 * @date 2024/3/2 16:44
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeopAeProductSkuDTO {
    //aeop_s_k_u_national_discount_price	Object[]	否	sku分国家的日常促销价
    private List<AeopSkuNationalDiscountPriceDTO> aeop_s_k_u_national_discount_price;
    //aeop_s_k_u_property	Object[]	否	sku属性列表
    private List<AeopSkuPropertyDTO> aeop_s_k_u_property;
    //barcode	String	否	商品条形码
    private String barcode;
    //currency_code	String	否	货币单位。如果不提供该值信息，则默认为"USD"；非俄罗斯卖家这个属性值可以不提供。对于俄罗斯海外卖家，该单位值必须提供，如: "RUB"。
    private String currency_code;
    //id	String	否	SKU id，格式：sku_property_id:sku_property_value_id,不需要变更类目不用传，自定义属性必传
    private String id;
    //ipm_sku_stock	Number	否	sku库存
    private Number ipm_sku_stock;
    //sku_code	String	否	商品编码
    private String sku_code;
    //sku_discount_price	String	否	sku日常促销价
    private String sku_discount_price;
    //sku_price	String	是	sku价格
    private String sku_price;
    //gross_weight	String	否	sku重量，单位公斤
    private String gross_weight;
    //package_height	Number	否	sku物流尺寸-高，单位cm
    private Number package_height;
    //package_width	String	否	sku物流尺寸-宽，单位cm
    private String package_width;
    //package_length	Number	否	sku物流尺寸-长，单位cm
    private Number package_length;
    //ean_code	String	否	eanCode
    private String ean_code;
    //sku的状态 ，是否销售，active ：销售 ； inactive ：不销售
    private String status;
}
