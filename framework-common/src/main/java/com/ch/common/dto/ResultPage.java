package com.ch.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @Author : lichong
 * @description : 分页信息
 * @Date Create in 14:32 2022/4/28
 * @Modified By :
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class ResultPage<T> extends ResultStatus {

    /**
     * 分页信息
     */
    private PageInfo<T> pageInfo;

}
