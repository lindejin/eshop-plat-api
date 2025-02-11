package com.eshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.eshop.mapper")
@SpringBootApplication
public class EshopPlatApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopPlatApiApplication.class, args);
    }

}
