package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:23
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeEcowarehouseReverseOrderStatusPostDTO {
    //        request.addApiParameter("send_reverse_callback_request", "{\"warehouse_customer_id\":\"4px\",\"ae_trade_order_id\":\"123124124214\",\"wms_order_id\":\"wms_order_id\",\"warehouse_code\":\"warehouse_code\",\"out_biz_id\":\"WH123124124\",\"reject_reason\":\"rejectReason\",\"logistic_param\":{\"tracking_no\":\"123123\",\"collect_type\":\"ONLINE_WAYBILL\",\"shipping_method\":\"shipping_method\",\"consign_type\":\"consign_type\",\"bill_info_url\":\"123123\",\"qr_code\":\"123123\",\"logistics_company_name\":\"123123\",\"qr_code_url\":\"123123\"},\"order_status_name\":\"order_status_name\",\"order_create_time\":\"124124124\",\"event_code\":\"event_code\",\"item_list\":[{\"ae_sku_id\":\"42352345\",\"operate_info_list\":[{\"operate_type\":\"operateType\",\"quantity\":\"1\",\"inventory_type\":\"101\",\"scan_item_code\":\"scan_item_code\"},{\"operate_type\":\"operateType\",\"quantity\":\"1\",\"inventory_type\":\"101\",\"scan_item_code\":\"scan_item_code\"}],\"sku_id\":\"42352345\",\"operate_result\":\"operate_result\",\"extend_filed\":{}},{\"ae_sku_id\":\"42352345\",\"operate_info_list\":[{\"operate_type\":\"operateType\",\"quantity\":\"1\",\"inventory_type\":\"101\",\"scan_item_code\":\"scan_item_code\"},{\"operate_type\":\"operateType\",\"quantity\":\"1\",\"inventory_type\":\"101\",\"scan_item_code\":\"scan_item_code\"}],\"sku_id\":\"42352345\",\"operate_result\":\"operate_result\",\"extend_filed\":{}}],\"order_status_code\":\"order_status_code\",\"error_code\":\"error_code\",\"order_update_time\":\"124124214\",\"pic_for_whole_pkg\":\"true\",\"goods_owner_id\":\"ownerId\",\"event_time\":\"12312313\"}");
    private String send_reverse_callback_request;
}
