package com.eshop.config.limit;

// 基础重试策略接口
public interface RetryStrategy {
    long calculateDelay(int attempt);

    long getInterval(int attempt);
}