package com.ch.common.base;

/**
 * @Author : lichong
 * @description :  返回参数定义信息
 * @Date Create in 14:48 2022/4/28
 * @Modified By :
 **/
public interface ResStatusInterface {

    /**
     * 参数定义名称
     *
     * @return
     */
    String name();

    /**
     * 响应编码
     */
    String getCode();

    /**
     * 响应信息
     */
    String getMsg();
}
