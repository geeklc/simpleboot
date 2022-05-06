package com.ch.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ch.common.common.AppConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Author : lichong
 * @description : 定义数据库实体的创建人，创建时间，修改人，修改时间等
 * @Date Create in 14:52 2022/5/5
 * @Modified By :
 **/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AppBaseEntity extends AppBaseIdEntity {

    /**
     * 创建人的id，create_user_id
     */
    private Long createUserId;

    /**
     * 创建时间 create_time
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern= AppConstants.DATE_TIME_PATTERN)
    private LocalDateTime createTime;

    /**
     * 修改人id， update_user_id
     */
    private Long updateUserId;

    /**
     * 修改时间  update_time
     */
    @JsonFormat(pattern= AppConstants.DATE_TIME_PATTERN)
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
