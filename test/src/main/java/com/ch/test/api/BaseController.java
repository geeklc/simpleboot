package com.ch.test.api;

import com.ch.common.dto.PageInfo;
import com.ch.common.dto.ResultPage;
import com.ch.common.util.UtilResult;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 17:30 2022/5/6
 * @Modified By :
 **/

public class BaseController extends UtilResult {

    /**
     * 设置配置信息
     *
     * @param pageInfo
     * @param <T>
     * @return
     */
    public static <T> PageInfo<T> getPageInfo(com.github.pagehelper.PageInfo<T> pageInfo) {
        PageInfo<T> page = new PageInfo();
        page.setList(pageInfo.getList());
        page.setPageNum(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setTotalRows(pageInfo.getTotal());
        page.setTotalPages(pageInfo.getPages());
        return page;
    }

    /**
     * 获取pageInfo的参数实体
     *
     * @param pageInfo
     * @return
     */
    public static <T> ResultPage<T> getResultPageInfo(com.github.pagehelper.PageInfo<T> pageInfo) {
        PageInfo<T> page = getPageInfo(pageInfo);
        return getResultPageInfo(page);
    }
}
