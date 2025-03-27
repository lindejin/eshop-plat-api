package com.eshop.dynamic.datasource;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceProperty;
import com.baomidou.dynamic.datasource.destroyer.DataSourceDestroyer;
import com.baomidou.dynamic.datasource.destroyer.DefaultDataSourceDestroyer;
import com.baomidou.dynamic.datasource.ds.GroupDataSource;
import com.baomidou.dynamic.datasource.ds.ItemDataSource;
import com.baomidou.dynamic.datasource.exception.ErrorCreateDataSourceException;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.logistics.temu.TemuOrderPoLogisticsCall;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.TemuOrderPoCallService;
import com.eshop.util.shop.PlatformAppClientUtils;
import com.p6spy.engine.spy.P6DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@SpringBootTest
public class DynamicRoutingDataSourceTest2 {

    @Resource
    private DynamicRoutingDataSourceTest dynamicRoutingDataSourceTest;

    @Resource
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Resource
    private TemuOrderPoLogisticsCall temuOrderPoLogisticsCall;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuOrderPoCallService temuOrderPoCallService;

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

    private Set<String> putDs(String poolName,DataSource newDataSource) {
        try {
            DynamicRoutingDataSource ds = dynamicRoutingDataSource;
            ds.addDataSource(poolName, newDataSource);
            return ds.getDataSources().keySet();
        } catch (ErrorCreateDataSourceException e) {
            log.error("数据源初始化期间出现异常", e);
            throw new RuntimeException("数据源初始化期间出现异常", e);
        }
    }

//    /**
//     * 所有数据库
//     */
//    private final Map<String, DataSource> dataSourceMap = new ConcurrentHashMap<>();
//
//    /**
//     * 分组数据库
//     */
//    private final Map<String, GroupDataSource> groupDataSources = new ConcurrentHashMap<>();
//
//    private static final String UNDERLINE = "_";
//
//    private Boolean graceDestroy = false;
//    /**
//     * 添加数据源
//     *
//     * @param ds         数据源名称
//     * @param dataSource 数据源
//     */
//    public synchronized void addDataSource(String ds, DataSource dataSource) {
//        DataSource oldDataSource = dataSourceMap.put(ds, dataSource);
//        // 新数据源添加到分组
//        this.addGroupDataSource(ds, dataSource);
//        // 关闭老的数据源
//        if (oldDataSource != null) {
//            closeDataSource(ds, oldDataSource, graceDestroy);
//        }
//        log.info("dynamic-datasource - add a datasource named [{}] success", ds);
//    }
//
//    /**
//     * 新数据源添加到分组
//     *
//     * @param ds         新数据源的名字
//     * @param dataSource 新数据源
//     */
//    private void addGroupDataSource(String ds, DataSource dataSource) {
//        if (ds.contains(UNDERLINE)) {
//            String group = ds.split(UNDERLINE)[0];
//            GroupDataSource groupDataSource = groupDataSources.get(group);
//            if (groupDataSource == null) {
//                try {
//                    // groupDataSource = new GroupDataSource(group, strategy.getDeclaredConstructor().newInstance());
//                    groupDataSources.put(group, groupDataSource);
//                } catch (Exception e) {
//                    throw new RuntimeException("dynamic-datasource - add the datasource named " + ds + " error", e);
//                }
//            }
//            groupDataSource.addDatasource(ds, dataSource);
//        }
//    }
//
//
//    /**
//     * close db
//     *
//     * @param ds           dsName
//     * @param dataSource   db
//     * @param graceDestroy If true, close the connection after a delay.
//     */
//    private void closeDataSource(String ds, DataSource dataSource, boolean graceDestroy) {
//        try {
//            DataSource realDataSource = null;
//            if (dataSource instanceof ItemDataSource) {
//                realDataSource = ((ItemDataSource) dataSource).getRealDataSource();
//            } else {
//                if (true) {
//                    if (dataSource instanceof P6DataSource) {
//                        Field realDataSourceField = P6DataSource.class.getDeclaredField("realDataSource");
//                        realDataSourceField.setAccessible(true);
//                        realDataSource = (DataSource) realDataSourceField.get(dataSource);
//                    }
//                }
//            }
//
//            if (null == realDataSource) {
//                realDataSource = dataSource;
//            }
//            if (null != realDataSource) {
//                DataSourceDestroyer destroyer = new DefaultDataSourceDestroyer();
//                if (graceDestroy) {
//                    destroyer.asyncDestroy(ds, realDataSource);
//                } else {
//                    destroyer.destroy(ds, realDataSource);
//                }
//            }
//        } catch (Exception e) {
//            log.warn("dynamic-datasource closed datasource named [{}] failed", ds, e);
//        }
//    }




//    private Set<String> putDs(DataSourceProperty dsp) {
//        try {
//            DynamicRoutingDataSource ds = (DynamicRoutingDataSource) this.dataSource;
//            DataSource newDataSource = defaultDataSourceCreator.createDataSource(dsp);
//            ds.addDataSource(dsp.getPoolName(), newDataSource);
//            return ds.getDataSources().keySet();
//        } catch (ErrorCreateDataSourceException e) {
//            log.error("数据源初始化期间出现异常", e);
//            throw new BizException("数据源初始化期间出现异常", e);
//        }
//    }

}
