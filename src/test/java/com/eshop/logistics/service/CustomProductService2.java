package com.eshop.logistics.service;

import com.eshop.annotation.StrategyKey;
import org.springframework.stereotype.Service;

@Service
@StrategyKey("CUSTOM_KEY_2")
public class CustomProductService2 implements ProductService {
    @Override
    public String process(String input) {
        return "Processed by CustomProductService2: " + input;
    }
}
