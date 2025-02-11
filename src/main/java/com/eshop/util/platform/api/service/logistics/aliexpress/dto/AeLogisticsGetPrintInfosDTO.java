package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 10:50
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsGetPrintInfosDTO {
    //   request.addApiParameter("print_detail", "false");
    private String print_detail;
    //   request.addApiParameter("warehouse_order_query_d_t_os", "[{\"international_logistics_id\":\"RE700150389CN\",\"id\":\"123432423\"}]");
    private String warehouse_order_query_d_t_os;
}
