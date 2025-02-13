package com.eshop.order.client.impl;

import com.eshop.annotation.StrategyKey;
import com.eshop.constant.ConstantPlatform;
import com.eshop.order.client.OrderClient;
import org.springframework.stereotype.Service;

@Service
@StrategyKey(ConstantPlatform.ALIEXPRESS)
public class AliExpressAscpOrderClient implements OrderClient {

    @Override
    public String process(String input) {
        return "速卖通半托管: " + input;
    }

}