package com.eshop.config.limit;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * temu限流工具类
 */
@lombok.Getter
@lombok.Setter
@Slf4j
public class TemuRateLimit {

    private final AtomicLong lastTime = new AtomicLong(0);

    /**
     * 请求间隔 xx毫秒请求一次
     */
    private long defaultInterval;

    /**
     * 请求失败重试次数
     */
    private int defaultMaxRetries;

    // 必须提供无参构造函数（用于手动实例化）
    public TemuRateLimit() {}

    public TemuRateLimit(long defaultInterval, int defaultMaxRetries) {
        this.defaultInterval = defaultInterval;
        this.defaultMaxRetries = defaultMaxRetries;
    }
    /**
     * 基础执行方法（带精准限流）
     */
    private <T> T executeCore(SupplierWithException<T> supplier, long interval) throws Exception {
        long now;
        long expected;

        do {
            now = System.currentTimeMillis();
            expected = lastTime.get();
            long nextTime = expected + interval;

            if (now < nextTime) {
                sleep(nextTime - now);
                now = System.currentTimeMillis();
            }
        } while (!lastTime.compareAndSet(expected, now));

        return supplier.get();
    }

    /**
     * 智能重试入口方法
     */
    public <T> T executeWithRetry(SupplierWithException<T> supplier) {
        return executeWithRetryHandle(supplier, defaultMaxRetries,
                new FixedIntervalStrategy(defaultInterval));
    }

    /**
     * 全参数重试方法
     *
     * @param supplier      业务逻辑
     * @param maxAttempts   最大尝试次数（含首次）
     * @param retryStrategy 重试策略
     */
    public <T> T executeWithRetryHandle(SupplierWithException<T> supplier, int maxAttempts,
                                        RetryStrategy retryStrategy) {
        int attempts = 0;
        long nextInterval = 0;

        String msg = "";
        while (attempts < maxAttempts) {
            try {
                if (attempts > 0) {
                    sleep(nextInterval);
                }
                return executeCore(supplier, retryStrategy.getInterval(attempts));
            } catch (Exception e) {
                log.error("进行了一次限流失败重试!");
                nextInterval = retryStrategy.calculateDelay(attempts);
                attempts++;
                if (e instanceof TemuRetryException) {
                    msg = ((TemuRetryException) e).getMessage();
                }
            }
        }
        throw new TemuRetryException("操作重试失败，已达最大次数: " + maxAttempts + "," + msg);
    }

    private static void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 带异常声明的Supplier
    @FunctionalInterface
    public interface SupplierWithException<T> {
        T get() throws Exception;
    }
}