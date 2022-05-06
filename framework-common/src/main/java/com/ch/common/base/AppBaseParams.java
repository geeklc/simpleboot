package com.ch.common.base;

import com.ch.common.common.AppConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 17:21 2022/5/6
 * @Modified By :
 **/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AppBaseParams extends BaseBean{

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 分页数
     */
    private Integer pageNum;


    public Integer getPageSize() {
        return (pageSize == null || pageSize < 0) ? AppConstants.DEFAULT_PAGE_SIZE : pageSize;
    }

    public Integer getPageNum() {
        return (pageNum == null || pageNum < 0) ? AppConstants.DEFAULT_PAGE_NUM : pageNum;
    }
}
