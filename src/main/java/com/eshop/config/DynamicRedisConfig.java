package com.eshop.config;

import io.lettuce.core.ClientOptions;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Configuration
public class DynamicRedisConfig {

    @Getter
    private volatile LettuceConnectionFactory activeConnectionFactory;
    private LettuceConnectionFactory standbyConnectionFactory;

    // 在 DynamicRedisConfig 中添加容错
    public LettuceConnectionFactory getActiveConnectionFactory() {
        try {
            // 尝试获取连接，如果失败则重置
            if (activeConnectionFactory.getConnection() == null) {
                activeConnectionFactory.resetConnection();
            }
        } catch (Exception e) {
            activeConnectionFactory.resetConnection();
        }
        return activeConnectionFactory;
    }


    // 初始化默认配置（从application.yml加载）
    @Bean
    @Primary
    public LettuceConnectionFactory defaultConnectionFactory(
            @Value("${spring.redis.host}") String host,
            @Value("${spring.redis.port}") int port,
            @Value("${spring.redis.password}") String password,
            @Value("${spring.redis.database}") int database) {

        LettuceConnectionFactory factory = createNewFactory(host, port,password,database);
        this.activeConnectionFactory = factory;
        return factory;
    }

    private LettuceConnectionFactory createNewFactory(String host, int port, String password,int database) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, port);
        config.setPassword(RedisPassword.of(password));
        config.setDatabase(database);

        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .commandTimeout(Duration.ofMillis(30000))
                .shutdownTimeout(Duration.ofSeconds(10))  // 设置关闭超时
                .clientOptions(ClientOptions.builder()
                        .autoReconnect(true)
                        .build())
                .build();

        LettuceConnectionFactory factory = new LettuceConnectionFactory(config, clientConfig);
        factory.afterPropertiesSet();
        return factory;
    }

    // 动态切换方法
    public synchronized void switchConnectionFactory(String newHost, int newPort, String password,int database) {
        // 1. 创建新连接工厂
        LettuceConnectionFactory newFactory = createNewFactory(newHost, newPort,password,database);

        // 2. 切换流程
        standbyConnectionFactory = activeConnectionFactory;
        activeConnectionFactory = newFactory;

        // 3. 异步关闭旧连接池（延迟30秒）
        Executors.newSingleThreadScheduledExecutor()
                .schedule(() -> standbyConnectionFactory.destroy(), 30, TimeUnit.SECONDS);
    }

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(DynamicRedisConfig config) {
//        return new RedisTemplate<String, Object>() {
//            @Override
//            public RedisConnectionFactory getConnectionFactory() {
//                return config.getActiveConnectionFactory();
//            }
//
//            @Override
//            public void afterPropertiesSet() {
//                super.setConnectionFactory(getConnectionFactory());
//                super.setKeySerializer(new StringRedisSerializer());
//                super.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//                super.afterPropertiesSet();
//            }
//        };
//    }
}