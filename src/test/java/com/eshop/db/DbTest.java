package com.eshop.db;

import com.eshop.config.DynamicRedisConfig;
import com.eshop.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.sql.DataSource;
import java.util.Map;

@Slf4j
@SpringBootTest
public class DbTest {

    @Autowired
    private DynamicRedisConfig dynamicRedisConfig;

    @Autowired
    private Map<String, SqlSessionFactory> stringSqlSessionFactoryMap;

    @Autowired
    private Map<String, SqlSessionTemplate> stringSqlSessionTemplateMap;

    @Autowired
    private Map<String, DataSource> dataSourceMap;

    @Test
    public void addSystem() {
        System.out.println(111);
        System.out.println(stringSqlSessionFactoryMap.size());
        System.out.println(stringSqlSessionTemplateMap.size());
        System.out.println(dataSourceMap.size());

    }

}
