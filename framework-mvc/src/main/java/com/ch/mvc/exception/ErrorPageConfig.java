package com.ch.mvc.exception;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author: lichong
 * @email: li_chong@massclouds
 * @Date: 2019/1/22 09:48
 * @Description: 按照错误的方式返回错误的页面
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //1、按错误的类型显示错误的网页
        //错误类型为404，找不到网页的，默认显示404.html网页
        ErrorPage error_404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
        //错误类型为500，表示服务器响应错误，默认显示500.html网页
        ErrorPage error_500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
        //错误的请求参数
        ErrorPage error_400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/400");
        //错误的请求方式
        ErrorPage error_405 = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/405");
        registry.addErrorPages(error_404, error_400, error_405, error_500);
    }
}
