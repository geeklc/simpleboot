package com.ch.common.config;

import com.ch.common.common.AppSecureProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 9:38 2022/4/27
 * @Modified By :
 **/
@Slf4j
@ComponentScan("com.ch.common")
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties({AppSecureProperties.class})
public class CommonAutoConfiguration {


}
