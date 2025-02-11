package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 16:55
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderAcceptCancelOrderDTO {
    //request.addApiParameter("param_order_cancel_request", "{\"buyer_login_id\":\"test1\",\"order_id\":\"2345789067\"}");

    private String param_order_cancel_request;

}
