package com.eshop.dynamic.datasource;

import com.eshop.config.DynamicRedisConfig;
import com.eshop.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@SpringBootTest
public class RedisSwitchControllerTest {

    @Autowired
    private DynamicRedisConfig dynamicRedisConfig;

    @Test
    public void addSystem() {
        String host = "192.168.10.53";
        int port = 6379;
        String password = "Aa132465";
        // 前置校验
        if (!testConnection(host, port, password)) {
            log.error("error Connection test failed");
            return ;
        }

        // 执行切换
        dynamicRedisConfig.switchConnectionFactory(host, port, password,2);// 前置校验
        if (!testConnection(host, port, password)) {
            log.error("error Connection test failed");
            return;
        }

        System.out.println(redisGet());
    }

    public String redisGet() {
        // 构造完整Redis Key
        String redisKey = "lingtu:requests:00801ea3-3ea8-4426-aa7c-09f71b8801be";
        // 获取数据（自动处理序列化）
        return RedisUtils.get(redisKey);
    }

    private boolean testConnection(String host, int port, String password) {
        try (RedisConnection connection = createTempConnection(host, port, password)) {
            return "PONG".equals(connection.ping());
        } catch (Exception e) {
            return false;
        }
    }

    private RedisConnection createTempConnection(String host, int port, String password) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, port);
        config.setPassword(RedisPassword.of(password));
        LettuceConnectionFactory factory = new LettuceConnectionFactory(config);
        factory.afterPropertiesSet();
        return factory.getConnection();
    }
}
