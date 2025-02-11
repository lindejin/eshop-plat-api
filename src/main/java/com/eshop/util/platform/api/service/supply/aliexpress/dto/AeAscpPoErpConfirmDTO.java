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
public class AeAscpPoErpConfirmDTO {
    // TODO 这里不用订单主键id了，使用第三方平台的订单编号
//    channel_user_id	Number	是
    private Number channel_user_id;
//    merchant_code	String	是
    private String merchant_code;
//    purchase_order_no	String	是

    private String purchase_order_no;
//    gmt_pre_delivery	String	否
    private String gmt_pre_delivery;
//    all_quantity_confirm	Boolean	是
    private Boolean all_quantity_confirm;
//    reason	String	否
    private String reason;
//   demo
    private List<AeAscpPoErpConfirmItemDTO> purchase_confirm_item_list;
}
