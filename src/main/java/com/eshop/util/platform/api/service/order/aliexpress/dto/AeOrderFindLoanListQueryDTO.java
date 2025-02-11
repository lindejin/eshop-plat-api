package com.eshop.util.platform.api.service.order.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/28 17:16
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeOrderFindLoanListQueryDTO {
    //request.addApiParameter("param1", "{\"loan_status\":\"wait_loan\",\"create_date_end\":\"10/09/2013 00:00:00\",\"create_date_start\":\"10/08/2013 00:00:00\",\"page\":\"1\",\"order_id\":\"97191172200623\",\"page_size\":\"20\"}");
    private String param1;
}
