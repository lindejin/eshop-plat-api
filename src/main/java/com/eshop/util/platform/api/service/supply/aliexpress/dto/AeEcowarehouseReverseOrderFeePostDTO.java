package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:26
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeEcowarehouseReverseOrderFeePostDTO {
    //        request.addApiParameter("reverse_fee_detail_callback_request", "{\"warehouse_customer_id\":\"4px\",\"time_stamp\":\"123123\",\"wms_order_id\":\"123123\",\"warehouse_code\":\"warehouse_code\",\"fee_details\":[{\"quantity\":\"1\",\"total_amount\":\"555\",\"expense_code\":\"SHIPPPING\",\"currency\":\"USD\",\"unit_price\":\"555\"},{\"quantity\":\"1\",\"total_amount\":\"555\",\"expense_code\":\"SHIPPPING\",\"currency\":\"USD\",\"unit_price\":\"555\"}],\"tracking_number\":\"123123\",\"out_biz_id\":\"WH123123\",\"goods_owner_id\":\"123123\",\"package_info\":{\"length\":\"1\",\"width\":\"2\",\"weight\":\"422\",\"height\":\"3\"}}");
    private String reverse_fee_detail_callback_request;
}
