package com.eshop.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class YourService {

    private final Map<String, ProductService> strategyMap;

    @Autowired
    public YourService(StrategyKeyRegistrar strategyKeyRegistrar) {
        this.strategyMap = strategyKeyRegistrar.getStrategyMap();
    }

    public void executeStrategy(String key, String input) {
        ProductService productService = strategyMap.get(key);
        if (productService != null) {
            System.out.println(productService.process(input));
        } else {
            System.out.println("No strategy found for key: " + key);
        }
    }
}
