package com.ch.dao.support;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

/**
 * @Author : lichong
 * @description : 默认的id生成方式
 * @Date Create in 13:36 2022/5/5
 * @Modified By :
 **/
public class DefaultIdGenerator implements IdentifierGenerator {


    @Override
    public Number nextId(Object entity) {

        return IdUtil.getSnowflakeNextId();
    }

    @Override
    public String nextUUID(Object entity) {
        return IdUtil.fastSimpleUUID();
    }
}
