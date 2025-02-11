package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:25
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpPoCancelDTO {
    //        request.addApiParameter("purchase_order_cancel_request", "{\"store_code\":\"AET001\",\"merchant_code\":\"AEGDCHAIN\",\"request_no\":\"AET001_1658246400000\"}");
    private String purchase_order_cancel_request;
}
