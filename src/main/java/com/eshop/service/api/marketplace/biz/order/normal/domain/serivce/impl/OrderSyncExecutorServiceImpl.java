package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.impl;

import com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.OrderSyncExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * @author ldj
 * @date 2024/7/30 10:37
 * @Description: ...
 * @Version 1.0
 */
@Slf4j
@Service
public class OrderSyncExecutorServiceImpl implements OrderSyncExecutorService {

    @Resource(name = "orderSynPool")
    private Executor orderSynPool;

    @Resource(name = "shopeeOrderSyncPool")
    private Executor shopeeOrderSyncPool;

    @Resource(name = "tiktokOrderSyncPool")
    private Executor tiktokOrderSyncPool;
    @Resource(name = "temuOrderSyncPool")
    private Executor temuOrderSyncPool;

    @Override
    public Executor getOrderSyncPool(String platformCode) {
        if ("Shopee".equals(platformCode)) {
            return shopeeOrderSyncPool;
        }
        if ("TikTok".equals(platformCode)) {
            return tiktokOrderSyncPool;
        }
        if ("Temu".equals(platformCode)) {
            return temuOrderSyncPool;
        }
        return orderSynPool;
    }
}
