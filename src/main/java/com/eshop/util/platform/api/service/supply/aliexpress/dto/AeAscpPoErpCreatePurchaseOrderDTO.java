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
public class AeAscpPoErpCreatePurchaseOrderDTO {
//    purchase_order_no  String  是  备货单号
    private String purchase_order_no;
//    本次发货此PO单的货品个数。最大100个。
    private List<AeAscpPoErpCreatePurchaseOrderItemDTO> purchase_order_item_list;
}
