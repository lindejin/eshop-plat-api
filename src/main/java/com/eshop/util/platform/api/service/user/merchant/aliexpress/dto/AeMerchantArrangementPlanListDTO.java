package com.eshop.util.platform.api.service.user.merchant.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/23 14:22
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeMerchantArrangementPlanListDTO {
    //        request.addApiParameter("planType", "12");
    private String planType;
    //        request.addApiParameter("planId", "1");
    private String planId;
    //        request.addApiParameter("pageNo", "-");
    private String pageNo;
    //        request.addApiParameter("pageSize", "-");
    private String pageSize;
    //        request.addApiParameter("sort", "-");
    private String sort;
    //        request.addApiParameter("categoryPath", "-");
    private String categoryPath;
    //        request.addApiParameter("region", "-");
    private String region;
    //        request.addApiParameter("priceRange", "-");
    private String priceRange;
    //        request.addApiParameter("priceRangeCurrency", "-");
    private String priceRangeCurrency;
    //        request.addApiParameter("opportunitySource", "-");
    private String opportunitySource;
    //        request.addApiParameter("joinStatus", "-");
    private String joinStatus;
    //        request.addApiParameter("planStatus", "-");
    private String planStatus;
    //        request.addApiParameter("hasCollected", "-");
    private String hasCollected;
}
