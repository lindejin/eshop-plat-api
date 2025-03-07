package com.eshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAsync//可以异步执行,开启多线程
@EnableScheduling//多种规则的任务调度功能,开启对定时任务的支持
@EnableAspectJAutoProxy   //开启基于注解的AOP模式
@MapperScan("com.eshop.mapper")
@SpringBootApplication
public class EshopPlatApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopPlatApiApplication.class, args);
    }

}
