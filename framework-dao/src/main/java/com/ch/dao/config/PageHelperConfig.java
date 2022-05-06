package com.ch.dao.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author : lichong
 * @description : PageHelper分页配置
 * @Date Create in 16:54 2022/5/6
 * @Modified By :
 **/
@Configuration
public class PageHelperConfig {
    @Autowired
    private AppDaoProperties properties;

    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor page = new PageInterceptor();
        Properties property = new Properties();
        //0、设置数据库断言
        if (properties.getDataSource().getPool().getDbType() != null) {
            property.setProperty("helperDialect", properties.getDataSource().getPool().getDbType().name());
        }
        //1、设置分页合理化参数，当该参数设置为 true 时，curPage<=0 时会查询第一页; curPage>pages（超过总数时），会查询最后一页
        property.setProperty("reasonable", "true");
        //2、pageSizeZero默认值为 false，当该参数设置为 true 时，如果 pageSize=0 或者 RowBounds.limit = 0
        // 就会查询出全部的结果（相当于没有执行分页查询，但是返回结果仍然是 Page 类型）
        property.setProperty("pageSizeZero", "true");
        /*
          3、supportMethodsArguments：支持通过 Mapper 接口参数来传递分页参数，默认值false，分页插件会从查询方法的参数值中，
            自动根据上面 params 配置的字段中取值，查找到合适的值时就会自动分页
         */
        property.setProperty("supportMethodsArguments", "true");

        page.setProperties(property);
        return page;
    }
}
