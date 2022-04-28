package com.ch.common.dto;

import lombok.Data;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 14:27 2022/4/28
 * @Modified By :
 **/
@Data
public class ResultData<T> extends ResultStatus{

    /**
     * 数据
     */
    private T data;
}
