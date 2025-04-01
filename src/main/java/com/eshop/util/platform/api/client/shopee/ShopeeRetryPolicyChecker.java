package com.eshop.util.platform.api.client.shopee;

import com.google.common.collect.ImmutableSet;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Set;

/**
 * Shopee API重试策略决策器
 * 核心功能：
 * 1. 判断指定异常是否可重试
 * 2. 计算指数退避时间
 * 3. 管理最大重试次数
 */
public class ShopeeRetryPolicyChecker {

    // 可重试的HTTP状态码白名单
    private static final Set<HttpStatus> RETRYABLE_STATUSES = ImmutableSet.of(
            HttpStatus.REQUEST_TIMEOUT,          // 408
            HttpStatus.TOO_MANY_REQUESTS,        // 429
            HttpStatus.INTERNAL_SERVER_ERROR,    // 500
            HttpStatus.BAD_GATEWAY,              // 502
            HttpStatus.SERVICE_UNAVAILABLE,      // 503
            HttpStatus.GATEWAY_TIMEOUT           // 504
    );

    public static boolean shouldRetry(HttpClientErrorException ex, int attemptCount) {
        return RETRYABLE_STATUSES.contains(ex.getStatusCode())
                && attemptCount < 3;
    }

    // 带退避时间的重试计算
    public static long calculateBackoff(int attemptCount) {
        return (long) Math.pow(2, attemptCount) * 1000L; // 指数退避
    }
}
