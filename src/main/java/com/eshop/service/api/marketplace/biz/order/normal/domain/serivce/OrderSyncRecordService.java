package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce;

import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.webutil.order.TbOrderInfo;

/**
 * @author ldj
 * @date 2023/6/26 14:04
 * @Description: ...
 * @Version 1.0
 */
public interface OrderSyncRecordService {

    /**
     * addOrderSynMap 订单同步相关信息入库
     * @param orderInfo
     * @throws Exception
     */
    void addOrderDetailSyn(TbOrderInfo orderInfo) throws Exception;

    /**
     * updateOrderSynMap 订单同步相关信息入库 更新
     * @param orderInfo
     * @throws Exception
     */
    void updateOrderDetailSyn(TbOrderInfo orderInfo) throws Exception;

    /**
     * 订单同步相关信息入库 申请取消
     */
    void inCancelOrderDetailSyn(PlatformSyncDTO psDTO,TbOrderInfo orderInfo) throws Exception;
}
