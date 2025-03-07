package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce;

import com.eshop.modal.modal.eshop_order.TbOrder;
import com.eshop.modal.modal.eshop_order.TbOrderBuyerInfo;
import com.eshop.modal.modal.eshop_order.TbWaybillSite;

/**
 * @author ldj
 * @date 2023/12/9 14:45
 * @Description: 推广订单服务
 * @Version 1.0
 */
public interface OrderSyncPromotionOrderService {

    /**
     * 推广订单处理
     */
    void promotionOrderProcessor(TbOrder order, TbOrderBuyerInfo orderBuyer, TbWaybillSite tbWaybillSite,Long creatorId) throws Exception;
}
