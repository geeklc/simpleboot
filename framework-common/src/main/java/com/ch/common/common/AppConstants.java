package com.ch.common.common;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 17:40 2022/4/28
 * @Modified By :
 **/
public interface AppConstants {


    /**
     * 默认日期时间格式
     */
    String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认日期格式
     */
    String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 删除标识字段
     */
    String DEL_FILED = "delFlag";

    /**
     * 删除值
     */
    Integer DEL_VALUE = 1;

    /**
     * 未被删除值
     */
    Integer NOT_DEL_VALUE = 0;

    /**
     * 默认分页大小
     */
    int DEFAULT_PAGE_SIZE = 10;

    /**
     * 默认分页数
     */
    int DEFAULT_PAGE_NUM = 1;

}
