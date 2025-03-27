package com.eshop.dynamic.datasource;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.creator.DataSourceProperty;
import com.baomidou.dynamic.datasource.creator.DefaultDataSourceCreator;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.eshop.config.DatabaseIpProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class DynamicRoutingDataSourceTest {

    private final List<DynamicDataSourceProvider> providers;

    private final DynamicDataSourceProperties properties;

    private final DefaultDataSourceCreator defaultDataSourceCreator;

    private final DatabaseIpProperties databaseIpProperties;

    public Map<String, DataSource> loadDataSources() {
        Map<String, DataSourceProperty> dataSourcePropertiesMap = properties.getDatasource();
        return createDataSourceMap(dataSourcePropertiesMap);
    }

    /**
     * 创建数据源
     *
     * @param dataSourcePropertiesMap 数据源参数Map
     * @return 数据源Map
     */
    protected Map<String, DataSource> createDataSourceMap(
            Map<String, DataSourceProperty> dataSourcePropertiesMap) {
        Map<String, DataSource> dataSourceMap = new HashMap<>(dataSourcePropertiesMap.size() * 2);
        for (Map.Entry<String, DataSourceProperty> item : dataSourcePropertiesMap.entrySet()) {
            String dsName = item.getKey();
            DataSourceProperty dataSourceProperty = item.getValue();
            String poolName = dataSourceProperty.getPoolName();
            if (poolName == null || "".equals(poolName)) {
                poolName = dsName;
            }
            String originalUrl = dataSourceProperty.getUrl();
            String newIp  = databaseIpProperties.getIp();
            // 替换 IP
            String newUrl = JdbcUrlUtil.replaceIpInJdbcUrl(originalUrl, newIp);
            dataSourceProperty.setUrl(newUrl);
            dataSourceProperty.setPoolName(poolName);
            dataSourceMap.put(dsName, defaultDataSourceCreator.createDataSource(dataSourceProperty));
        }
        return dataSourceMap;
    }
}
