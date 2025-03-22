package com.eshop.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 * @author KFC(chenxiangrong163 @ 163.com)
 * @Date 2021-09-29 16:11
 * @Description 
 */
@EnableAsync
@Component
@Configurable
public class AsyncConfig {
    /**
     * excel任务 线程池配置
     *
     * @return
     */
    @Bean("excelTaskPool")
    public Executor excelTaskPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池数量，方法: 返回可用处理器的Java虚拟机的数量。
        executor.setCorePoolSize(8);
        //最大线程数量
        executor.setMaxPoolSize(8);
        //线程池的队列容量
        executor.setQueueCapacity(2000);
        //线程名称的前缀
        executor.setThreadNamePrefix("excel-task-pool-executor");
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //如果不初始化，导致找到不到执行器
        executor.initialize();
        return executor;
    }
}
