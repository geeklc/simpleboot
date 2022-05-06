package com.ch.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : lichong
 * @description : 定数数据库实体的主键
 * @Date Create in 14:29 2022/5/5
 * @Modified By :
 **/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AppBaseIdEntity extends BaseBean {

    /**
     *  数据库主键id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
}
