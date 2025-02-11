package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:22
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeEcowarehouseOrderStatusPostDTO {
    //        request.addApiParameter("send_wms_fulfill_callback_request", "{\"warehouse_customer_id\":\"DES\",\"ae_trade_order_id\":\"8145069480275002  \\t\",\"warehouse_code\":\"CUSTOM001\",\"wms_order_id\":\"order_id_test_123456\",\"owner_id\":\"111\",\"out_biz_id\":\"B2CSHIP_610000248001_2578625002\",\"reject_reason\":\"\u5BA2\u6237\u8D39\u7528\u4E0D\u591F\",\"package_list\":[{\"package_width\":\"100\",\"package_height\":\"100\",\"order_mail_no\":\"mail_no_test_123456\",\"shipping_method\":\"EUROPAK\",\"logistics_company_en\":\"DHL\",\"package_length\":\"100\",\"logistics_company_cn\":\"DHL\",\"package_weight\":\"100\",\"package_sku_list\":[{\"quantity\":\"2\",\"ae_sku_id\":\"SHU-1\",\"sku_id\":\"SHU-1\"},{\"quantity\":\"2\",\"ae_sku_id\":\"SHU-1\",\"sku_id\":\"SHU-1\"}]},{\"package_width\":\"100\",\"package_height\":\"100\",\"order_mail_no\":\"mail_no_test_123456\",\"shipping_method\":\"EUROPAK\",\"logistics_company_en\":\"DHL\",\"package_length\":\"100\",\"logistics_company_cn\":\"DHL\",\"package_weight\":\"100\",\"package_sku_list\":[{\"quantity\":\"2\",\"ae_sku_id\":\"SHU-1\",\"sku_id\":\"SHU-1\"},{\"quantity\":\"2\",\"ae_sku_id\":\"SHU-1\",\"sku_id\":\"SHU-1\"}]}],\"order_status_name\":\"teststatus\",\"order_create_time\":\"1643007221142\",\"order_outbound_time\":\"1643007221142\",\"event_code\":\"WAREHOUSE_ORDER_OUTBOUND\",\"order_status_code\":\"teststatus\",\"error_code\":\"111\",\"order_update_time\":\"1643007221142\",\"event_time\":\"1643007221142\"}");
    private String send_wms_fulfill_callback_request;
}
