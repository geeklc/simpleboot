package com.ch.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author : lichong
 * @description : 分页信息
 * @Date Create in 14:27 2022/4/28
 * @Modified By :
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> {

    /**
     * 当前页数
     */
    public int pageNum;

    /**
     * 总页数
     */
    public int totalPages;

    /**
     * 页面大小
     */
    public int pageSize;

    /**
     * 总行数
     */
    public Long totalRows;


    /**
     * 数据列表
     */
    private List<T> list;
}
