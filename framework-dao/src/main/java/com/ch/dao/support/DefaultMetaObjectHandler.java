package com.ch.dao.support;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ch.common.common.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author : lichong
 * @description : 默认自定义填充字段信息
 * @Date Create in 11:20 2022/5/6
 * @Modified By :
 **/
@Component
@Slf4j
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入是定义的自定义
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //0、判断实体是否设置了创建时间字段
        boolean createTime = metaObject.hasSetter("createTime");
        if (createTime) {
            this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(), LocalDateTime.class);
        }
        //1、判断实体是否有删除字段
        boolean delField = metaObject.hasSetter(AppConstants.DEL_FILED);
        if (delField) {
            this.strictInsertFill(metaObject, AppConstants.DEL_FILED, () -> AppConstants.NOT_DEL_VALUE, Integer.class);
        }
        //2、todo 配置创建人
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //0、判断实体是否设置了更新时间字段
        boolean updateTime = metaObject.hasSetter("updateTime");
        if (updateTime) {
            this.strictUpdateFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class);
        }
        //1、todo 配置修改人
    }
}
