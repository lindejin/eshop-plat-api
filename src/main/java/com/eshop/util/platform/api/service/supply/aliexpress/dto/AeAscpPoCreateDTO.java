package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:11
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpPoCreateDTO {
    //        request.addApiParameter("purchase_order_create_request", "{\"store_code\":\"AET001\",\"merchant_code\":\"AEGDCHAIN\",\"eta\":\"1658246400000\",\"delivery_type\":\"1\",\"biz_type\":\"288000\",\"inbound_wave\":\"1\",\"request_no\":\"AET001_1658246400000\",\"remark\":\"\u5907\u6CE8\",\"items\":[{\"quantity\":\"2\",\"sc_item_id\":\"123\"},{\"quantity\":\"2\",\"sc_item_id\":\"123\"}]}");
    private String purchase_order_create_request;
}
