/*
 * Copyright © 2018 organization baomidou
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baomidou.dynamic.datasource.creator.atomikos;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.baomidou.dynamic.datasource.creator.DataSourceCreator;
import com.baomidou.dynamic.datasource.creator.DataSourceProperty;
import com.baomidou.dynamic.datasource.enums.DdConstants;
import com.baomidou.dynamic.datasource.enums.XADataSourceEnum;
import com.baomidou.dynamic.datasource.toolkit.ConfigMergeCreator;
import com.mysql.cj.jdbc.MysqlXADataSource;
import com.p6spy.engine.spy.P6DataSource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.sql.DataSource;


/**
 * Atomikos数据源配置
 *
 * @author <a href="mailto:312290710@qq.com">jiazhifeng</a>
 */
@NoArgsConstructor
@AllArgsConstructor
public class AtomikosDataSourceCreator implements DataSourceCreator {
    private static final ConfigMergeCreator<AtomikosConfig, AtomikosConfig> MERGE_CREATOR = new ConfigMergeCreator<>("AtomikosConfig", AtomikosConfig.class, AtomikosConfig.class);
    private AtomikosConfig atomikosConfig;

    @Override
    public DataSource createDataSource(DataSourceProperty dataSourceProperty) {
        AtomikosConfig config = MERGE_CREATOR.create(atomikosConfig, dataSourceProperty.getAtomikos());

        MysqlXADataSource mysqlXADataSource = createMysqlXADataSource(dataSourceProperty);
        AtomikosDataSourceBean sourceBean = new AtomikosDataSourceBean();
        // 包装数据源在 P6Spy 中
        P6DataSource p6DataSource = new P6DataSource(mysqlXADataSource);

        sourceBean.setXaDataSource(p6DataSource);
        // 必须为数据源指定唯一标识
        sourceBean.setMinPoolSize(5);
        sourceBean.setMaxPoolSize(20);
        sourceBean.setBorrowConnectionTimeout(60);
        sourceBean.setTestQuery("SELECT 1");
        sourceBean.setUniqueResourceName(dataSourceProperty.getPoolName() + "__atomikos");
        //设置池维护线程的维护间隔 单位秒
        sourceBean.setMaintenanceInterval(30);
        sourceBean.setMaxIdleTime(60);
        sourceBean.setMaxLifetime(60);
        //设置并发连接验证
        sourceBean.setConcurrentConnectionValidation(true);
        return sourceBean;
    }

    @Override
    public boolean support(DataSourceProperty dataSourceProperty) {
        Class<? extends DataSource> type = dataSourceProperty.getType();
        return (type == null || DdConstants.ATOMIKOS_DATASOURCE.equals(type.getName())) && XADataSourceEnum.contains(dataSourceProperty.getDriverClassName());
    }

    /**
     * 创建数据库 MysqlXADataSource
     */
    public static MysqlXADataSource createMysqlXADataSource(DataSourceProperty dataSourceProperty) {
        MysqlXADataSource result = new MysqlXADataSource();
        try {
            result.setUrl(dataSourceProperty.getUrl());
            result.setUser(dataSourceProperty.getUsername());
            result.setPassword(dataSourceProperty.getPassword());
            result.setPinGlobalTxToPhysicalConnection(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}