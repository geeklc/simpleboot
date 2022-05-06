package com.ch.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : lichong
 * @description : 软删除标识
 * @Date Create in 14:59 2022/5/5
 * @Modified By :
 **/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AppSoftDelEntity extends AppBaseEntity{

    /**
     * 是否删除字段
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;
}
