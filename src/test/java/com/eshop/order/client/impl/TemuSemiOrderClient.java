package com.eshop.order.client.impl;

import com.eshop.annotation.StrategyKey;
import com.eshop.constant.ConstantPlatform;
import com.eshop.order.client.OrderClient;
import org.springframework.stereotype.Service;


@Service
@StrategyKey(ConstantPlatform.TEMU)
public class TemuSemiOrderClient implements OrderClient {

    @Override
    public String process(String input) {
        return "TEMU半托管订单: " + input;
    }

}