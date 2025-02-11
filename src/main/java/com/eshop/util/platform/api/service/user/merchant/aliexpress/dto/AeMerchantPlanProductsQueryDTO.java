package com.eshop.util.platform.api.service.user.merchant.aliexpress.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/4/23 14:28
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeMerchantPlanProductsQueryDTO {
    //        request.addApiParameter("planId", "-");
    private String planId;
    //        request.addApiParameter("topCategoryId", "-");
    private String topCategoryId;
    //        request.addApiParameter("leafCategoryId", "-");
    private String leafCategoryId;
    //        request.addApiParameter("categoryPath", "-");
    private String categoryPath;
    //        request.addApiParameter("countGroupEnum", "-");
    private String countGroupEnum;
    //        request.addApiParameter("productStatus", "-");
    private String productStatus;
    //        request.addApiParameter("productIds", "-");
    private String productIds;
    //        request.addApiParameter("productName", "-");
    private String productName;
    //        request.addApiParameter("productId", "-");
    private String productId;
    //        request.addApiParameter("productPublishTimeStart", "-");
    private String productPublishTimeStart;
    //        request.addApiParameter("productPublishTimeEnd", "-");
    private String productPublishTimeEnd;
    //        request.addApiParameter("planType", "-");
    private String planType;
    //        request.addApiParameter("productApplyStatus", "-");
    private String productApplyStatus;
    //        request.addApiParameter("pageNo", "-");
    private String pageNo;
    //        request.addApiParameter("pageSize", "-");
    private String pageSize;
    //        request.addApiParameter("sort", "-");
    private String sort;
}
