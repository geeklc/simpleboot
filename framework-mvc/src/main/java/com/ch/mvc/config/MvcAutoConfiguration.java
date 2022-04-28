package com.ch.mvc.config;

import lombok.extern.slf4j.Slf4j;
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
@ComponentScan("com.ch.mvc")
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MvcAutoConfiguration {


}
