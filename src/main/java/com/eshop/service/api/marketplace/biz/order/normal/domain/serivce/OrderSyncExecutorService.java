package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce;

import java.util.concurrent.Executor;

/**
 * @author ldj
 * @date 2024/7/30 10:37
 * @Description: ...
 * @Version 1.0
 */
public interface OrderSyncExecutorService {

    Executor getOrderSyncPool(String platformCode);
}
