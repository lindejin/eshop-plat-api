package com.eshop.config;

import org.apache.hc.client5.http.ConnectionKeepAliveStrategy;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Configuration
public class HttpClientConfig {

    @Bean
    public SSLConnectionSocketFactory sslSocketFactory() throws Exception {
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial((chain, authType) -> true) // 信任所有证书
                .build();
        return SSLConnectionSocketFactoryBuilder.create()
                .setSslContext(sslContext)
                .build();
    }

    // 连接池配置（网页6、网页7）
    @Bean
    public PoolingHttpClientConnectionManager poolingConnectionManager() {
        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager();
        pool.setMaxTotal(200);                     // 总连接数上限
        pool.setDefaultMaxPerRoute(50);            // 单路由最大连接数
        pool.setValidateAfterInactivity(TimeValue.ofSeconds(30)); // 空闲连接验证
        return pool;
    }

    // 默认请求配置（网页7）
    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig.custom()
                .setConnectTimeout(Timeout.ofSeconds(5))       // 建立连接超时
                .setConnectionRequestTimeout(Timeout.ofSeconds(3)) // 从连接池获取连接超时
                .setResponseTimeout(Timeout.ofSeconds(30))     // 等待数据超时
                .build();
    }

    // 重试策略（网页9、网页10）
    @Bean
    public DefaultHttpRequestRetryStrategy retryStrategy() {
        int maxRetries = 3; // 定义最大重试次数
        TimeValue retryInterval = TimeValue.ofSeconds(5);

        return new DefaultHttpRequestRetryStrategy(maxRetries, retryInterval) {
            //@Override
            //public boolean retryRequest(HttpRequest request, int execCount, HttpContext context) {
            @Override
            public boolean retryRequest(HttpRequest request, IOException exception, int execCount, HttpContext context) {
                return execCount <= maxRetries && "GET".equalsIgnoreCase(request.getMethod());
            }
        };
    }

    // 连接保活策略（网页6）
    @Bean
    public ConnectionKeepAliveStrategy keepAliveStrategy() {
        return (response, context) -> TimeValue.ofMinutes(5); // 保持连接5分钟
    }

    // 监控线程（网页6）
    @Bean
    public ScheduledExecutorService connectionMonitor() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            try {
                poolingConnectionManager().closeExpired();
                poolingConnectionManager().closeIdle(TimeValue.ofMinutes(1));
            } catch (Exception e) {
                // 异常处理
            }
        }, 30, 30, TimeUnit.SECONDS); // 每30秒清理一次
        return scheduler;
    }

    // HTTP日志拦截器（网页1、网页9）
    @Bean
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }

    // 构建HttpClient（综合网页1、网页6、网页7）
    @Bean
    public CloseableHttpClient httpClient() throws Exception {
        return HttpClientBuilder.create()
                .setConnectionManager(poolingConnectionManager())
                .setDefaultRequestConfig(requestConfig())
                .setRetryStrategy(retryStrategy())
                .setKeepAliveStrategy(keepAliveStrategy())
                .addRequestInterceptorFirst(httpLoggingInterceptor().requestInterceptor())
                .addResponseInterceptorFirst(httpLoggingInterceptor().responseInterceptor())
                .build();
    }
}