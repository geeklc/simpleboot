package com.ch.dao.config;

import com.alibaba.druid.DbType;
import com.alibaba.druid.pool.DruidAbstractDataSource;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.LocalCacheScope;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author : lichong
 * @description : 数据源配置信息
 * @Date Create in 16:00 2022/4/29
 * @Modified By :
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = AppDaoProperties.PREFIX)
public class AppDaoProperties {
    public final static String PREFIX = "app.dao";

    /**
     * 数据源信息
     */
    private MyDataSource dataSource = new MyDataSource();

    /**
     * mybatis配置信息
     */
    private Mybatis mybatis = new Mybatis();


    /**
     * 自定义数据源信息
     */
    @Getter
    @Setter
    public static class MyDataSource {
        /**
         * 是否启用数据源配置
         */
        private boolean enabled = true;

        /**
         * 驱动类名
         */
        private String driverClassName;

        /**
         * 连接地址
         */
        private String url;

        /**
         * 用户名
         */
        private String username;

        /**
         * 密码
         */
        private String password;

        /**
         * 数据库连接池配置
         */
        private MyPool pool = new MyPool();
    }

    /**
     * 池定义
     */
    @Getter
    @Setter
    public static class MyPool {

        /**
         * 池的初始化大小
         */
        private int initialSize = DruidAbstractDataSource.DEFAULT_INITIAL_SIZE;

        /**
         * 最小空闲数
         */
        private int minIdle = DruidAbstractDataSource.DEFAULT_MIN_IDLE;

        /**
         * 最大活跃数
         */
        private int maxActive = DruidAbstractDataSource.DEFAULT_MAX_ACTIVE_SIZE;

        /**
         * 数据库类型
         */
        private DbType dbType;

        /**
         * 获取连接等待超时的时间
         */
        private long maxWait = 20000;

        /**
         * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
         */
        private long timeBetweenEvictionRunsMillis = DruidAbstractDataSource.DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS;

        /**
         * 配置一个连接在池中最小生存的时间，单位是毫秒
         */
        private long minEvictableIdleTimeMillis = DruidAbstractDataSource.DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS;

        /**
         * 验证查询sql
         */
        private String validationQuery;
    }

    /**
     * mybatis配置信息
     */
    @Getter
    @Setter
    public static class Mybatis {
        /**
         *  MyBatis 配置文件位置
         */
        private String configLocation;

        /**
         * mapper.xml的地址
         */
        private String mapperLocations;

        /**
         * 设置typeAlias 包扫描路径
         */
        private String typeAliasesPackage;

        /**
         * 该配置请和 typeAliasesPackage 一起使用，如果配置了该属性，则仅仅会扫描路径下以该类作为父类的域对象
         */
        private String typeAliasesSuperType;

        /**
         * 是否驼峰命名
         */
        private boolean mapUnderscoreToCamelCase = true;

        /**
         * 是否开启一级缓存
         */
        private LocalCacheScope localCacheScope = LocalCacheScope.STATEMENT;

        /**
         * 是否开启二级缓存
         */
        private boolean cacheEnabled = false;

        /**
         * 表名前缀
         */
        private String tablePrefix;
    }
}

