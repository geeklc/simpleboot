package com.ch.test.api.userinfo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ch.common.base.AppSoftDelEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 15:52 2022/5/5
 * @Modified By :
 **/
@Data
@TableName("user_info")
public class UserInfoEntity extends AppSoftDelEntity {


    /**
     * 用户姓名
     */
    @NotEmpty(message = "用户姓名不能为空")
    private String userName;

    /**
     *
     */
    private Integer gender;
}
