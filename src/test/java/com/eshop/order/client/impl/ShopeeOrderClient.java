package com.eshop.order.client.impl;

import com.eshop.annotation.StrategyKey;
import com.eshop.constant.ConstantPlatform;
import com.eshop.order.client.OrderClient;
import org.springframework.stereotype.Service;


@Service
@StrategyKey(ConstantPlatform.SHOPEE)
public class ShopeeOrderClient implements OrderClient {

    @Override
    public String process(String input) {
        return "虾皮普通订单: " + input;
    }

}