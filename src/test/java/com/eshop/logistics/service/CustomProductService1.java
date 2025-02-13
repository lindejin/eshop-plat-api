package com.eshop.logistics.service;

import com.eshop.annotation.StrategyKey;
import org.springframework.stereotype.Service;

@Service
@StrategyKey("CUSTOM_KEY_1")
public class CustomProductService1 implements ProductService {
    @Override
    public String process(String input) {
        return "Processed by CustomProductService1: " + input;
    }
}
