package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author xxs
 * @date 2024/9/19
 * @Description: AE仓发备货单-分页查询单据 DTO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeAscpPoErpCancelDTO {

//    channel_user_id	Number	是
    private Number channel_user_id;
//    merchant_code	String	是
    private String merchant_code;
//    consign_order_no	String	是
    private String consign_order_no;
//    cancel_reason	String	否
    private String cancel_reason;
}
