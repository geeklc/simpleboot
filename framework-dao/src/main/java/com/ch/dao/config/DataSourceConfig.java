package com.ch.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 13:19 2018/5/13
 * @Modified By :
 **/
@Configuration
@Slf4j
@ConditionalOnProperty(prefix = AppDaoProperties.PREFIX, name = "dataSource.enabled", havingValue = "true")
@EnableTransactionManagement
public class DataSourceConfig {
    @Autowired
    private AppDaoProperties properties;

    /**
     * druid的连接池信息
     *
     * @return
     */
    @Bean
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        AppDaoProperties.MyDataSource dataSource = properties.getDataSource();
        druidDataSource.setUsername(dataSource.getUsername());
        druidDataSource.setPassword(dataSource.getPassword());
        druidDataSource.setUrl(dataSource.getUrl());
        druidDataSource.setDriverClassName(dataSource.getDriverClassName());
        AppDaoProperties.MyPool pool = dataSource.getPool();
        druidDataSource.setInitialSize(pool.getInitialSize());
        druidDataSource.setMinIdle(pool.getMinIdle());
        druidDataSource.setMaxActive(pool.getMaxActive());
        druidDataSource.setDbType(pool.getDbType());
        druidDataSource.setTimeBetweenEvictionRunsMillis(pool.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(pool.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(pool.getValidationQuery());
        return druidDataSource;
    }


}
