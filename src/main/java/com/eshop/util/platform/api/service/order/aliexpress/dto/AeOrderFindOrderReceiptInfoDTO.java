package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 17:26
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderFindOrderReceiptInfoDTO {
    // request.addApiParameter("param1", "{\"buyer_aliid\":\"100000\",\"show_id\":\"1\",\"seller_operator_aliid\":\"20000\",\"seller_aliid\":\"20000\",\"field_list\":\"orderAmount\",\"ext_info_bit_flag\":\"10100\",\"order_id\":\"123456789\"}");
    private String param1;

}
