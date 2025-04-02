package com.eshop.dynamic.datasource;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.exception.ErrorCreateDataSourceException;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@SpringBootTest
public class DynamicRoutingDataSourceTest2 {

    @Resource
    private DynamicRoutingDataSourceTest dynamicRoutingDataSourceTest;

    @Resource
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Test
    public void addSystem() {
        // 动态新增数据源
        // 添加并分组数据源
        Map<String, DataSource> dataSources = new HashMap<>(16);
        Map<String, DataSource> dsMap = dynamicRoutingDataSourceTest.loadDataSources();
        if (dsMap != null) {
            dataSources.putAll(dsMap);
        }
        for (Map.Entry<String, DataSource> dsItem : dataSources.entrySet()) {
            putDs(dsItem.getKey(), dsItem.getValue());
        }

        TbShop shopDO = shopService.getById(2500L);
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, "GL");
    }

    private Set<String> putDs(String poolName, DataSource newDataSource) {
        try {
            DynamicRoutingDataSource ds = dynamicRoutingDataSource;
            ds.addDataSource(poolName, newDataSource);
            return ds.getDataSources().keySet();
        } catch (ErrorCreateDataSourceException e) {
            log.error("数据源初始化期间出现异常", e);
            throw new RuntimeException("数据源初始化期间出现异常", e);
        }
    }
}
