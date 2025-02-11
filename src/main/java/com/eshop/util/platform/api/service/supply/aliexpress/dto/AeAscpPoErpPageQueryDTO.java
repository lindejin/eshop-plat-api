package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xxs
 * @date 2024/9/19
 * @Description: AE仓发备货单-分页查询单据 DTO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeAscpPoErpPageQueryDTO {

//    channel_user_id	Number	是
    private Number channel_user_id;
//    merchant_code	String	是
    private String merchant_code;
//    page_index	Number	否
    private Number page_index;
//    page_size	Number	否
    private Number page_size;
//    gmt_create_begin	String	否
    private String gmt_create_begin;
//    gmt_create_end	String	否
    private String gmt_create_end;
//    purchase_order_no_list	String[]	否
    private List<String> purchase_order_no_list;
//    biz_status	String	否
    private String biz_status;
}
