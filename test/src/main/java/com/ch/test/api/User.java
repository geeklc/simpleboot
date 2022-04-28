package com.ch.test.api;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 16:04 2022/4/28
 * @Modified By :
 **/
@Data
public class User {

    private String userId;

    @NotEmpty(message = "姓名为空")
    private String name;

    private Integer age;
}
