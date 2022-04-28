package com.ch.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/5/7.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum BaseResEnum implements ResStatusInterface{
    /**
     * 网络通讯状态码
     */
    HTTP_STATUS_400("400", "请求参数错误！"),
    HTTP_STATUS_401("401", "请登录！！"),
    HTTP_STATUS_403("403", "您没有相应的访问权限"),
    HTTP_STATUS_404("404", "请求路径不存在"),
    HTTP_STATUS_405("405", "错误的请求方式！"),
    HTTP_STATUS_500("500", "系统忙，请稍后再试!"),

    /**
     * 通用成功和通用失败
     */
    COMMON_FAIL("500", "系统忙，请稍后再试!"),
    COMMON_SUCCESS("200", "成功"),
    ;

    private String code;

    private String msg;

}
