package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/13 16:47
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeAscpRoQueryDTO {
    //        request.addApiParameter("return_order_query", "{\"return_order_no\":\"Ro123\",\"biz_type\":\"123\"}");
    private String return_order_query;
}
