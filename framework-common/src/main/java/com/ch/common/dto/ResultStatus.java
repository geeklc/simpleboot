package com.ch.common.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.ch.common.base.BaseBean;
import com.ch.common.common.AppConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 14:23 2022/4/28
 * @Modified By :
 **/
@Data
public class ResultStatus extends BaseBean {
    /**
     * 响应编码
     */
    private String code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应时间
     */
    @JsonFormat(pattern= AppConstants.DATE_TIME_PATTERN)
    private Date resTime;


    public Date getResTime() {
        return new Date();
    }
}
