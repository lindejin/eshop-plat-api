package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 16:53
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderDecryptOrderDTO {
//        request.addApiParameter("orderId","8152891820014001");
    private String orderId;
//        request.addApiParameter("oaid","MjAwMDQyMzYw-ssfsvnL3Nv%2B%2B54ABsv%2BaoQ");
    private String oaid;
}
