package com.eshop.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final YourService yourService;

    @Autowired
    public AppRunner(YourService yourService) {
        this.yourService = yourService;
    }

    @Override
    public void run(String... args) throws Exception {
        yourService.executeStrategy("CUSTOM_KEY_1", "Hello World");
        yourService.executeStrategy("CUSTOM_KEY_2", "Another Input");
    }
}