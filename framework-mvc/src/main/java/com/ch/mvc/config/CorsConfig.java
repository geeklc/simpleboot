package com.ch.mvc.config;

import com.ch.common.common.AppSecureProperties;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;

/**
 * @Author : lichong
 * @description : 配置跨域请求
 * @Date Create in 17:34 2022/4/28
 * @Modified By :
 **/
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements WebMvcConfigurer {
    @Autowired
    private AppSecureProperties properties;



    /**
     * 设置跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        AppSecureProperties.CORSConfig cors = properties.getCors();
        if (cors.isEnable()) {
            //0、配置路径范围
            registry.addMapping(cors.getPathPattern())
                    //1、是否添加请求头
                    .allowedHeaders(getArrays(cors.getAllowedHeaders()))
                    //2、允许跨域的方法
                    .allowedMethods(getArrays(cors.getAllowedMethods()))
                    //3、允许跨域的域名
                    .allowedOrigins(getArrays(cors.getAllowedOrigins()))
                    //4、是否允许发送cookie
                    .allowCredentials(cors.isAllowCredentials());
        }
    }

    /**
     * Set转String
     *
     * @param infos
     * @return
     */
    private String[] getArrays(Set<String> infos) {
        if (CollectionUtils.isNotEmpty(infos)) {
            return infos.toArray(new String[infos.size()]);
        } else {
            return new String[]{"*"};
        }
    }
}
