package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:59
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpPoCancelPickupOrderDTO {
    //        request.addApiParameter("param0", "{\"cancel_reason\":\"\u8BA2\u5355\u9519\u8BEF\",\"system_operate\":\"true\",\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\",\"pickup_order_number\":\"GF1234567\"}");
    private String param0;
}
