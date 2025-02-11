package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 16:01
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductFeedListGetDTO {
    //request.addApiParameter("current_page", "2");
    private String current_page;
    //request.addApiParameter("feed_type", "PRODUCT_CREATE");
    private String feed_type;
    //request.addApiParameter("page_size", "50");
    private String page_size;
    //request.addApiParameter("status", "FINISH");
    private String status;
    //request.addApiParameter("submitted_time_end", "2020-11-12 06:00:00");
    private String submitted_time_end;
    //request.addApiParameter("submitted_time_start", "2020-11-01 02:00:00");
    private String submitted_time_start;
}
