package com.eshop.util.platform.api.service.freight.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 14:53
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeFreightCalculateFreightDTO {
    //request.addApiParameter("height", "1");
    private String height;
    //request.addApiParameter("weight", "1");
    private String weight;
    //request.addApiParameter("pack_add_weight", "1");
    private String pack_add_weight;
    //request.addApiParameter("count", "1");
    private String count;
    //request.addApiParameter("freight_template_id", "1000");
    private String freight_template_id;
    //request.addApiParameter("pack_add_unit", "1");
    private String pack_add_unit;
    //request.addApiParameter("is_custom_pack_weight", "false");
    private String is_custom_pack_weight;
    //request.addApiParameter("width", "1");
    private String width;
    //request.addApiParameter("length", "1");
    private String length;
    //request.addApiParameter("product_price", "{\"amount\":\"100.01\",\"cent\":\"10000\",\"currency_code\":\"USD\"}");
    private String product_price;
    //request.addApiParameter("pack_base_unit", "1");
    private String pack_base_unit;
    //request.addApiParameter("country", "RU");
    private String country;
}
