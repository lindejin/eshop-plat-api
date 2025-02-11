package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 17:00
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpPoCancelSelfDeliveryDTO {
    //        request.addApiParameter("param0", "{\"cancel_reason\":\"\u4FE1\u606F\u586B\u5199\u9519\u8BEF\",\"self_delivery_no\":\"ZJ123456\",\"channel_user_id\":\"1234\",\"biz_type\":\"5110000\"}");
    private String param0;
}
