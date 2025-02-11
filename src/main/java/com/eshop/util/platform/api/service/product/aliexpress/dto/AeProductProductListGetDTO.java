package com.eshop.util.platform.api.service.product.aliexpress.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author ldj
 * @date 2024/2/29 15:42
 * @Description: ...
 * @Version 1.0
 */
@Getter
@Setter
public class AeProductProductListGetDTO {
    //        request.addApiParameter("aeop_a_e_product_list_query", "{\"gmt_modified_start\":\"2012-01-01 12:13:14\",\"gmt_modified_end\":\"2012-01-01 12:13:14\",\"off_line_time\":\"7\",\"gmt_create_start\":\"2012-01-01 12:13:14\",\"subject\":\"knew odd\",\"have_national_quote\":\"n\",\"ws_display\":\"expire_offline\",\"product_status_type\":\"onSelling\",\"owner_member_id\":\"aliqatest01\",\"gmt_create_end\":\"2012-01-01 12:13:14\",\"group_id\":\"1234\",\"product_id\":\"123\",\"excepted_product_ids\":[\"[32962333569,32813963253]\",\"[32962333569,32813963253]\"],\"sku_code\":\"123ABC\",\"current_page\":\"2\",\"page_size\":\"30\"}");
    private String aeop_a_e_product_list_query;
}
