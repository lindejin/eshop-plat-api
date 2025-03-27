package com.eshop.dynamic.datasource;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicRoutingDataSourceTest {

    private final List<DynamicDataSourceProvider> providers;

//    @Bean
//    @ConditionalOnMissingBean
//    public DataSource dataSource(List<DynamicDataSourceProvider> providers) {
//        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource(providers);
//        dataSource.setPrimary(properties.getPrimary());
//        dataSource.setStrict(properties.getStrict());
//        dataSource.setStrategy(properties.getStrategy());
//        dataSource.setP6spy(properties.getP6spy());
//        dataSource.setSeata(properties.getSeata());
//        dataSource.setGraceDestroy(properties.getGraceDestroy());
//        return dataSource;
//    }


    public DynamicRoutingDataSourceTest(List<DynamicDataSourceProvider> providers) {
        this.providers = providers;
    }
    public void afterPropertiesSet() {
        // 检查开启了配置但没有相关依赖
//        checkEnv();
        // 添加并分组数据源
//        Map<String, DataSource> dataSources = new HashMap<>(16);
//        for (DynamicDataSourceProvider provider : providers) {
//            Map<String, DataSource> dsMap = provider.loadDataSources();
//            if (dsMap != null) {
//                dataSources.putAll(dsMap);
//            }
//        }
//        for (Map.Entry<String, DataSource> dsItem : dataSources.entrySet()) {
//            addDataSource(dsItem.getKey(), dsItem.getValue());
//        }
    }
}
