package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xxs
 * @date 2024/9/19
 * @Description: AE仓发发货单-分页查询单据 DTO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeAscpCoErpPageQueryDTO {

//    channel_user_id	Number	是
    private Number channel_user_id;
//    merchant_code	String	是
    private String merchant_code;
//    consign_order_no_list	String[]	否
    private List<String> consign_order_no_list;
//    purchase_order_no	String	否
    private String purchase_order_no;
//    logistics_no_list	String[]	否
    private List<String> logistics_no_list;
//    pickup_no_list	String[]	否
    private List<String> pickup_no_list;
//    gmt_create_begin	String	否
    private String gmt_create_begin;
//    gmt_create_end	String	否
    private String gmt_create_end;
//    page_index	Number	否
    private Number page_index;
//    page_size	Number	否
    private Number page_size;
}
