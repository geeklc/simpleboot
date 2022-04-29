package com.ch.common.common;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 10:01 2022/4/29
 * @Modified By :
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "app.secure")
public class AppSecureProperties {

    private CORSConfig cors = new CORSConfig();

    @Getter
    @Setter
    public static class CORSConfig {
        /**
         * 默认启用跨域
         */
        private boolean enable = true ;

        /**
         * 表示是否允许发送Cookie。默认情况下，Cookie不包括在CORS请求之中；如果设为true，
         * 即表示服务器允许在请求中包含Cookie，一起发给服务器
         */
        private boolean allowCredentials = false;

        /**
         * 跨域控制路径范围
         */
        private String pathPattern = "/**";

        /**
         *  是否跨域的域名
         */
        private Set<String> allowedOrigins = Sets.newHashSet("*");

        /**
         * 允许跨域的方式，默认只有get 和 post请求
         */
        private Set<String> allowedMethods = Sets.newHashSet("GET", "POST" );

        /**
         * 是否添加请求头
         */
        private Set<String> allowedHeaders = Sets.newHashSet("*");
    }
}
