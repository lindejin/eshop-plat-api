package com.eshop.order.factory;

import com.eshop.order.client.OrderClient;
import com.eshop.order.registrar.OrderStrategyKeyRegistrar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
