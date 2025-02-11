package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:24
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsGetOnlineLogisticsServiceListByOrderIdDTO {
    //        request.addApiParameter("goods_width", "1");
    //        request.addApiParameter("goods_height", "1");
    //        request.addApiParameter("goods_weight", "1.5");
    //        request.addApiParameter("goods_length", "1");
    //        request.addApiParameter("order_id", "897234324234234");
    //        request.addApiParameter("locale", "ru_RU");
    private String goods_width;
    private String goods_height;
    private String goods_weight;
    private String goods_length;
    private String order_id;
    private String locale;
}
