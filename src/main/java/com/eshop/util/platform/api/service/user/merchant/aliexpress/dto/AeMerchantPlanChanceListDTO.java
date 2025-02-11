package com.eshop.util.platform.api.service.user.merchant.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/23 14:16
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeMerchantPlanChanceListDTO {

    //        request.addApiParameter("planId", "1");
    private String planId;
    //        request.addApiParameter("current", "1");
    private String current;
    //        request.addApiParameter("pageSize", "20");
    private String pageSize;
}
