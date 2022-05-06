package com.ch.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author : lichong
 * @description : 运行时spring对象管理类
 * @Date Create in 10:13 2022/4/27
 * @Modified By :
 **/
@Slf4j
@Component
public class UtilBeanFactory implements ApplicationContextAware {

    private static ApplicationContext APPLICATION_CONTEXT  = null ;

    @Override
    public void setApplicationContext( ApplicationContext applicationContext ){
        APPLICATION_CONTEXT = applicationContext ;
    }

    /**
     * 返回公共的请求上下文对象
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        return APPLICATION_CONTEXT ;
    }

}
