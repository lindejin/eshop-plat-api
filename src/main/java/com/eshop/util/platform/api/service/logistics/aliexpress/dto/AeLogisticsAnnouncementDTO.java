package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:39
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsAnnouncementDTO {
    //request.addApiParameter("seller_id", "200042360");
    //request.addApiParameter("start_time", "1622517071000");
    //request.addApiParameter("end_time", "1627787471000");
    private String seller_id;
    private String start_time;
    private String end_time;
}
