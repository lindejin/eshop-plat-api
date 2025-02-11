package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 17:28
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderSaveRemarkDTO {
//        request.addApiParameter("biz_type", "0");
    private String biz_type;
//        request.addApiParameter("remark_id", "23432412341234");
    private String remark_id;
//        request.addApiParameter("content", "hello");
    private String content;
}
