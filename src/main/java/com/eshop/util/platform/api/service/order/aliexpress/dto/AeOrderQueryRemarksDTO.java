package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 17:12
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderQueryRemarksDTO {
//    request.addApiParameter("biz_type", "0");
    private String biz_type;
//    request.addApiParameter("remark_ids", "123123123,123123124");
    private String remark_ids;
}
