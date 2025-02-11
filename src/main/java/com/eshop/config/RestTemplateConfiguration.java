package com.eshop.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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


}
