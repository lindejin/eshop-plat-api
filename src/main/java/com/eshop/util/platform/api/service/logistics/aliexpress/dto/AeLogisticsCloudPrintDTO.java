package com.eshop.util.platform.api.service.logistics.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/3/1 11:45
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeLogisticsCloudPrintDTO {
    //request.addApiParameter("print_detail", "true");
    //request.addApiParameter("warehouse_order_query_d_t_os", "[{\"extend_data\":\"[{\\\"imageUrl\\\":\\\"http://xxxxxx\\\",\\\"productDescription\\\":\\\"ALIBAB\\\\r\\\\nALIBABA\\\\r\\\\nALIBABA\\\"}]\",\"international_logistics_id\":\"LM2342342CN\",\"id\":\"3546234234\"}]");
    private String print_detail;
    private String warehouse_order_query_d_t_os;
}
