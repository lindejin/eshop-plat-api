package com.eshop.util.platform.api.service.supply.aliexpress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xxs
 * @date 2024/9/19
 * @Description: AE仓发备货单-创建发货单
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AeAscpCoErpCreateDTO {
//    channel_user_id	Number	是	渠道seller id （可以在这个API中查询：global.seller.relation.query）， 请使用 business_type = ONE_STOP_SERVICE 的全托管店铺 channel_seller_id
    private Number channel_user_id;
//    merchant_code	String	是	经营组织 {全托管:AECHOICE}
    private String merchant_code;
//    order_source_code	String	是	用于幂等。 商家操作发货一次，{order_source_code} 应该唯一。 例：ERP第一次调用接口，入参本批次发货50件。第二次再次调用接口，入参发货50件。根据该字段判断第二次调用是超时重复调用，还是商家又操作发货50件(总计2个发货单，总发货100件)。
    private String order_source_code;
//    purchase_order_list	Object[]	是	本次发货PO单。最大1单。(本接口为单个创建CO单接口，创建之后CO单据状态为「待发货」。本接口调用1次，会为指定PO单创建1个CO单。需要创建多个CO单请调用多次)
    private List<AeAscpPoErpCreatePurchaseOrderDTO> purchase_order_list;
}
