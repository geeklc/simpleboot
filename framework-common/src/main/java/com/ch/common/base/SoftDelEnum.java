package com.ch.common.base;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author : lichong
 * @description : 删除标识
 * @Date Create in 15:00 2022/5/5
 * @Modified By :
 **/
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SoftDelEnum {
    DEL(1),

    UNDEL(0);

    @JsonValue
    private Integer delFlag;
}
