package com.eshop.config.limit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemuRateLimitConfig {

    /**
     * 默认配置
     * 限流 50 重试 5
     */
    @Bean("defaultRateLimiter50")
    public TemuRateLimit defaultRateLimiter50() {
        return new TemuRateLimit(50, 5); // interval=100ms, retries=5
    }

    /**
     * 默认配置
     * 限流 100 重试 5
     */
    @Bean("defaultRateLimiter100")
    public TemuRateLimit defaultRateLimiter100() {
        return new TemuRateLimit(100, 5); // interval=100ms, retries=5
    }

    /**
     * 默认配置
     * 限流 350 重试 5
     */
    @Bean("defaultRateLimiter350")
    public TemuRateLimit defaultRateLimiter350() {
        return new TemuRateLimit(350, 5); // interval=50ms, retries=3
    }
}
