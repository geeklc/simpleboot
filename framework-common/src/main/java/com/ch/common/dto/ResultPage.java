package com.ch.common.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author : lichong
 * @description : 分页信息
 * @Date Create in 14:32 2022/4/28
 * @Modified By :
 **/
@Data
public class ResultPage<T> extends ResultStatus {

    /**
     * 分页信息
     */
    private PageInfo pageInfo;

    /**
     * 数据列表
     */
    private List<T> list;
}
