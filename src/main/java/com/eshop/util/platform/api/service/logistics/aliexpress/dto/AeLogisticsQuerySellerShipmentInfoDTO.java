package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:05
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsQuerySellerShipmentInfoDTO {
    //        request.addApiParameter("logistics_no", "LT123456789CN");
    //        request.addApiParameter("trade_order_id", "8899213123123");
    //        request.addApiParameter("service_name", "CAINIAO_STANDARD");
    //        request.addApiParameter("sub_trade_order_index", "1");
    private String logistics_no;
    private String trade_order_id;
    private String service_name;
    private String sub_trade_order_index;
}
