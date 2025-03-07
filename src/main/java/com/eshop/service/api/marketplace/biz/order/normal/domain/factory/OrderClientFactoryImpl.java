package com.eshop.service.api.marketplace.biz.order.normal.domain.factory;

import cn.hutool.core.util.ObjectUtil;
import com.eshop.service.api.marketplace.biz.order.normal.domain.registrar.OrderStrategyKeyRegistrar;
import com.eshop.service.api.marketplace.biz.order.normal.domain.repository.OrderClient;
import com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.OrderSyncManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ldj
 * @date 2024/3/18 14:20
 * @Description: ...
 * @Version 1.0
 */
@Component
@Slf4j
public class OrderClientFactoryImpl implements OrderClientFactory {

    private final Map<String, List<OrderClient>> strategyMap;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    public OrderClientFactoryImpl(OrderStrategyKeyRegistrar orderStrategyKeyRegistrar) {
        this.strategyMap = orderStrategyKeyRegistrar.getStrategyMap();
    }

    @Override
    public List<OrderClient> getClient(String platformCode) {
        List<OrderClient> client = strategyMap.get(platformCode);
        if (client == null) {
            log.error(platformCode + "[平台订单 未实现]");
        }
        return client;
    }

    /**
     * 获取订单同步服务
     */
    @Override
    public List<OrderSyncManagerService> getSyncService(String platformCode) {
        List<OrderClient> clients = getClient(platformCode);
        if (ObjectUtil.isEmpty(clients)) {
            throw new RuntimeException("平台编码(" + platformCode + ")找不到对应的订单同步服务");
        }
        List<OrderSyncManagerService> orderSyncManagerServices = new ArrayList();
        for (OrderClient client : clients) {
            //从 Spring 的应用上下文中获取一个特定类型的 Bean 实例，并传递一个参数（这里是 client）
            OrderSyncManagerService orderSyncManagerServiceTemp = applicationContext.getBean(OrderSyncManagerService.class, client);
            orderSyncManagerServices.add(orderSyncManagerServiceTemp);
        }
        return orderSyncManagerServices;
    }
}
