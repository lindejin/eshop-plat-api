package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 16:57
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderRefuseCancelOrderDTO {
    //request.addApiParameter("param_order_cancel_request", "{\"buyer_login_id\":\"test\",\"memo\":\"already send googds\",\"order_id\":\"33440956789\"}");
    private String param_order_cancel_request;
}
