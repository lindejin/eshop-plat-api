package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:01
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeEcowarehouseInventoryChangeGetDTO {
    //        request.addApiParameter("inventory_change_notify_request", "{\"quantity\":\"123\",\"warehouse_customer_id\":\"123\",\"idempotent_id\":\"123\",\"ae_trade_order_id\":\"123\",\"owner_id\":\"123\",\"warehouse_code\":\"123\",\"out_biz_id\":\"123\",\"sku_id\":\"123\",\"type\":\"123\"}");
    private String inventory_change_notify_request;
}
