package com.eshop.logistics;

import com.eshop.logistics.service.YourService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppRunnerTest {

    private final YourService yourService;

    @Autowired
    public AppRunnerTest(YourService yourService) {
        this.yourService = yourService;
    }

    @Test
    void contextLoads() throws Exception {
        yourService.executeStrategy("CUSTOM_KEY_1", "Hello World");
        yourService.executeStrategy("CUSTOM_KEY_2", "Another Input");
    }

}
