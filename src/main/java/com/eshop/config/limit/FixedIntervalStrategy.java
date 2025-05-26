package com.eshop.config.limit;

// 固定间隔重试策略
public class FixedIntervalStrategy implements RetryStrategy {
    private final long interval;

    public FixedIntervalStrategy(long interval) {
        this.interval = interval;
    }

    @Override
    public long calculateDelay(int attempt) {
        return interval;
    }

    @Override
    public long getInterval(int attempt) {
        return interval;
    }
}
