package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xxs
 * @date 2024/9/19
 * @Description: AE仓发发货单-分页查询单据 DTO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeAscpCoErpPageQueryItemDTO {

//    channel_user_id	Number	是
    private Number channel_user_id;
//    merchant_code	String	是
    private String merchant_code;
//    page_index	Number	否
    private Number page_index;
//    page_size	Number	否
    private Number page_size;
//    consign_order_no	String	是
    private String consign_order_no;
}
