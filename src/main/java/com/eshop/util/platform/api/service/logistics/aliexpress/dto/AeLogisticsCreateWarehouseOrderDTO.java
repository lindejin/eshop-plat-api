package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 10:22
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsCreateWarehouseOrderDTO {
    //        request.addApiParameter("declare_product_d_t_os", "[{\"category_cn_desc\":\"\u8FDE\u8863\u88D9\",\"product_weight\":\"1.5\",\"aneroid_markup\":\"false\",\"product_num\":\"2\",\"only_battery\":\"false\",\"contains_special_goods\":\"false\",\"hs_code\":\"77234\",\"child_order_id\":\"1000172130022100\",\"product_declare_amount\":\"1.3\",\"sc_item_code\":\"scItem code\",\"sku_value\":\"sku value\",\"sc_item_name\":\"scItem name\",\"category_en_desc\":\"dress\",\"product_id\":\"1000\",\"breakable\":\"false\",\"sku_code\":\"sku code\",\"contains_battery\":\"false\",\"sc_item_id\":\"1000\"}]");
    private String declare_product_d_t_os;
    //        request.addApiParameter("domestic_logistics_company", "tiantiankuaidi");
    private String domestic_logistics_company;
    //        request.addApiParameter("domestic_logistics_company_id", "505");
    private String domestic_logistics_company_id;
    //        request.addApiParameter("domestic_tracking_no", "L12345899");
    private String domestic_tracking_no;
    //        request.addApiParameter("package_num", "1");
    private String package_num;
    //        request.addApiParameter("trade_order_from", "ESCROW");
    private String trade_order_from;
    //        request.addApiParameter("trade_order_id", "66715700375804");
    private String trade_order_id;
    //        request.addApiParameter("undeliverable_decision", "0");
    private String undeliverable_decision;
    //        request.addApiParameter("warehouse_carrier_service", "CPAM_WLB_FPXSZ;CPAM_WLB_CPHSH;CPAM_WLB_ZTOBJ;HRB_WLB_ZTOGZ;HRB_WLB_ZTOSH");
    private String warehouse_carrier_service;
    //        request.addApiParameter("address_d_t_os", "{\"receiver\":{\"member_type\":\"\u7C7B\u578B\",\"street_address\":\"street address\",\"country\":\"RU\",\"city\":\"Moscow\",\"mobile\":\"18766234324\",\"county\":\"county\",\"address_id\":\"1000\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"sender\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"pickup\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"from_warehouse_code\":\"AML001\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"},\"refund\":{\"member_type\":\"\u7C7B\u578B\",\"country\":\"RU\",\"street_address\":\"street address\",\"city\":\"Moscow\",\"county\":\"county\",\"address_id\":\"1000\",\"mobile\":\"18766234324\",\"trademanage_id\":\"cn234234234\",\"province\":\"Moscow\",\"phone\":\"098-234234\",\"street\":\"street\",\"post_code\":\"056202\",\"name\":\"Linda\",\"fax\":\"234234234\",\"email\":\"alibaba@alibaba.com\"}}");
    private String address_d_t_os;
    //        request.addApiParameter("invoice_number", "38577123");
    private String invoice_number;
    //        request.addApiParameter("top_user_key", "xxxxxxx");
    private String top_user_key;
    //        request.addApiParameter("insurance_coverage", "{\"cent\":\"99\",\"currency_code\":\"USD\"}");
    private String insurance_coverage;
    //        request.addApiParameter("is_agree_upgrade_reverse_parcel_insure", "true");
    private String is_agree_upgrade_reverse_parcel_insure;
}
