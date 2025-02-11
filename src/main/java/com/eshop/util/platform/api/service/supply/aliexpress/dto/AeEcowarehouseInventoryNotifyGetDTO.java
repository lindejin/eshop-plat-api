package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:03
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeEcowarehouseInventoryNotifyGetDTO {
    //        request.addApiParameter("inventory_notify_request", "{\"sku_inventory_list\":[{\"warehouse_code_inventory\":[{\"warehouse_code\":\"MAD01\",\"available_stock\":\"10\"},{\"warehouse_code\":\"MAD01\",\"available_stock\":\"10\"}],\"owner_id\":\"tesr\",\"sku_id\":\"12345\"},{\"warehouse_code_inventory\":[{\"warehouse_code\":\"MAD01\",\"available_stock\":\"10\"},{\"warehouse_code\":\"MAD01\",\"available_stock\":\"10\"}],\"owner_id\":\"tesr\",\"sku_id\":\"12345\"}],\"warehouse_customer_id\":\"tesr\",\"type\":\"tesr\"}");
    private String inventory_notify_request;
}
