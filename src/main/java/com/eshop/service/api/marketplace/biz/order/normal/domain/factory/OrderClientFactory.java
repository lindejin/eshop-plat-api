package com.eshop.service.api.marketplace.biz.order.normal.domain.factory;


import com.eshop.service.api.marketplace.biz.order.normal.domain.repository.OrderClient;
import com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.OrderSyncManagerService;

import java.util.List;

/**
 * @author ldj
 * @date 2023/11/17 14:57
 * @Description: ...
 * @Version 1.0
 */
public interface OrderClientFactory {

    /**
     * 获取平台同步订单接口服务
     *
     * @param platformCode
     * @return
     */
    List<OrderClient> getClient(String platformCode);

    List<OrderSyncManagerService> getSyncService(String platformCode);
}
