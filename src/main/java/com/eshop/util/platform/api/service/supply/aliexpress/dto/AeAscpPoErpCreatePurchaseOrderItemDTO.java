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
public class AeAscpPoErpCreatePurchaseOrderItemDTO {
//    sc_item_id	Number	是	货品ID
    private Number sc_item_id;
//    sent_qty	Number	是	发货数量
    private Number sent_qty;
//    delivery_finish	Boolean	是	是否发货完结{true/false}。 若选择了完结发货，您该品本次剩余未发货部分可不再发货，系统会自动完结该品的发货量。
    private Boolean delivery_finish;
//    package_list	Object[]	是	demo
    private List<AeAscpPoErpCreatePackageDTO> package_list;
//    po_line_id	Number	是	单据内货品id。对应查询备货单货品接口返回值。
    private Number po_line_id;
    
}
