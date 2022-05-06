package com.ch.dao.config;

import cn.hutool.core.util.SystemPropsUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.ch.common.common.AppConstants;
import com.ch.common.util.UtilString;
import com.ch.dao.support.DefaultIdGenerator;
import com.ch.dao.support.DefaultMetaObjectHandler;
import com.ch.dao.support.MapWrapperFactory;
import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Author : lichong
 * @description : mybatis-plus配置信息
 * @Date Create in 9:45 2022/5/5
 * @Modified By :
 **/

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = AppDaoProperties.PREFIX, name = "dataSource.enabled", havingValue = "true")
public class MybatisPlusConfig {
    private AppDaoProperties properties;
    private ApplicationContext applicationContext;

    public MybatisPlusConfig(AppDaoProperties properties, ApplicationContext applicationContext) {
        this.properties = properties;
        this.applicationContext = applicationContext;
        log.info("初始化mybatisPlusConfig===================");
    }

    /**
     * MapperScannerConfigurer继承BeanDefinitionRegistryPostProcessor，需要在对象创建时就需要获取相关实例对象，
     * 因此方法修饰符为static
     * @return
     */
   /* @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //由配置文件中获取mybatis映射DAO的路径
        mapperScannerConfigurer.setBasePackage(AppConstants.MYBATIS_PACKAGE_SCAN);
        mapperScannerConfigurer.setMarkerInterface(BaseMapper.class);
        return mapperScannerConfigurer;
    }*/

    /**
     * mysql的配置信息
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory getSqlSessionFactory(DataSource dataSource, PageInterceptor pageInterceptor) throws Exception {
        AppDaoProperties.Mybatis mybatis = properties.getMybatis();
        VFS.addImplClass(SpringBootVFS.class);
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //0、设置mybatis configuration 扫描路径
        if (UtilString.isNotEmpty(mybatis.getConfigLocation())) {
            bean.setConfigLocation(new ClassPathResource(mybatis.getConfigLocation()));
        }
        //1、设置MyBatis Mapper 所对应的 XML 文件位置
        if (UtilString.isNotEmpty(mybatis.getMapperLocations())) {
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatis.getMapperLocations()));
        }
        //2、设置typeAlias 包扫描路径
        if (UtilString.isNotEmpty(mybatis.getTypeAliasesPackage())) {
            bean.setTypeAliasesPackage(mybatis.getTypeAliasesPackage());
        }
        //3、设置mybatis的基本配置信息
        bean.setConfiguration(getMybatisConfiguration());
        //4、设置mybatis-plus的全局配置信息
        bean.setGlobalConfig(getGlobalConfig());
        //5、设置分页插件
        bean.setPlugins(pageInterceptor);
        return bean.getObject();
    }


    /**
     * mybatis的基本配置信息
     *
     * @return
     */
    @Bean
    public MybatisConfiguration getMybatisConfiguration() {
        MybatisConfiguration configuration = new MybatisConfiguration();
        AppDaoProperties.Mybatis mybatis = properties.getMybatis();
        //0、驼峰转换
        configuration.setMapUnderscoreToCamelCase(mybatis.isMapUnderscoreToCamelCase());
        //1、Mybatis 一级缓存，SESSION和STATEMENT，STATEMENT为关闭一级缓存
        configuration.setLocalCacheScope(mybatis.getLocalCacheScope());
        //2、设置 Mybatis 二级缓存，默认false
        configuration.setCacheEnabled(mybatis.isCacheEnabled());
        //3、设置resultMap返回map时进行驼峰命名
        configuration.setObjectWrapperFactory(new MapWrapperFactory());
        return configuration;
    }

    /**
     * 设置mybatsi-plus的全局配置信息
     *
     * @return
     */
    public GlobalConfig getGlobalConfig() {
        GlobalConfig config = new GlobalConfig();
        //0、设置id生成器
        setIdentifierGenerator(config);
        //1、设置数据库配置信息
        config.setDbConfig(getDbConfig());
        //2、设置自定义填充字段handler
        setMetaObjectHandler(config);
        return config;
    }

    /**
     * 获取主键生成器，检查spring容器里是否有对应的bean,有则进行消费
     *
     * @param <T>      泛型
     */
    private <T> void setIdentifierGenerator(GlobalConfig config) {
        IdentifierGenerator bean = new DefaultIdGenerator();
        if (this.applicationContext.getBeanNamesForType(IdentifierGenerator.class, false, false).length > 0) {
            bean = this.applicationContext.getBean(IdentifierGenerator.class);
        }
        config.setIdentifierGenerator(bean);
    }


    /**
     * 设置自定义字段填充handler，检查spring容器里是否有对应的bean,有则进行消费
     *
     * @param <T>      泛型
     */
    private <T> void setMetaObjectHandler(GlobalConfig config) {
        MetaObjectHandler bean = new DefaultMetaObjectHandler();
        if (this.applicationContext.getBeanNamesForType(MetaObjectHandler.class, false, false).length > 0) {
            bean = this.applicationContext.getBean(MetaObjectHandler.class);
        }
        config.setMetaObjectHandler(bean);
    }

    /**
     * 获取dbconfig
     *
     * @return
     */
    public GlobalConfig.DbConfig getDbConfig() {
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        //1、全局默认主键类型
        dbConfig.setIdType(IdType.ASSIGN_ID);
        //2、表名是否使用驼峰转下划线命名
        dbConfig.setTableUnderline(true);
        //3、设置删除字段标识
        dbConfig.setLogicDeleteField(AppConstants.DEL_FILED);
        //4、设置删除值
        dbConfig.setLogicDeleteValue(String.valueOf(AppConstants.DEL_VALUE));
        //5、设置非删除值
        dbConfig.setLogicNotDeleteValue(String.valueOf(AppConstants.NOT_DEL_VALUE));
        //6、设置表名前缀
        if (UtilString.isNotEmpty(properties.getMybatis().getTablePrefix())) {
            dbConfig.setTablePrefix(properties.getMybatis().getTablePrefix());
        }
        return dbConfig;
    }

    /**
     * 配置插件信息
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        AppDaoProperties.MyPool pool = properties.getDataSource().getPool();
        if (pool.getDbType() != null) {
            interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.getDbType(pool.getDbType().name())));
        }
        return interceptor;
    }

}
