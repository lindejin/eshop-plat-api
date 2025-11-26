package com.eshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolTaskExecutorConfig {


    @Bean("jstTaskExecutor")
    public Executor initExecutor (){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("jstTaskExecutor-");
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(100);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setKeepAliveSeconds(60);
        executor.initialize();
        return executor;
    }
}
