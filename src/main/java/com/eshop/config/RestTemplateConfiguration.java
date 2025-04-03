package com.eshop.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author lengleng
 * @date 2019/2/1 RestTemplate
 */
@Configuration
public class RestTemplateConfiguration {

    /**
     * 动态 REST 模板
     * @return {@link RestTemplate }
     */
    @Bean
    @ConditionalOnProperty(value = "spring.cloud.nacos.discovery.enabled", havingValue = "true", matchIfMissing = true)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 创建基于 OkHttp 的 RestTemplate
     * 功能说明：
     * - 10秒连接超时
     * - 30秒读取超时
     * - 支持服务发现（@LoadBalanced）
     */
    @Bean
    public RestTemplate okHttpRestTemplate() {
        return new RestTemplate(okHttpRequestFactory());
    }


    /**
     * 配置 OkHttp 客户端
     */
    private OkHttp3ClientHttpRequestFactory okHttpRequestFactory() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)    // 连接超时
                .readTimeout(30, TimeUnit.SECONDS)      // 读取超时
                .writeTimeout(30, TimeUnit.SECONDS)     // 写入超时
                .retryOnConnectionFailure(true)         // 自动重试
                .connectionPool(new ConnectionPool(     // 连接池配置
                        200,  // 最大空闲连接数
                        5,    // 保持存活时间
                        TimeUnit.MINUTES))
                .build();

        return new OkHttp3ClientHttpRequestFactory(client);
    }
}
