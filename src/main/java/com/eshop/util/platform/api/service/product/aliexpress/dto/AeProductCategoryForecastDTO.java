package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 17:34
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductCategoryForecastDTO {
    //request.addApiParameter("image_url", "https://ae01.alicdn.com/kf/S1f7eae683d124854973b72563474e170V.jpg");
    //request.addApiParameter("subject", "elle+sport+sujetador+deportivo+gunn+rosa");
    //request.addApiParameter("locale", "es");
    //request.addApiParameter("is_filter_by_permission", "N");
    private String image_url;
    private String subject;
    private String locale;
    private String is_filter_by_permission;
}
