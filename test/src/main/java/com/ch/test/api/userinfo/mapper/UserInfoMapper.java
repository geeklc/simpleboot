package com.ch.test.api.userinfo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ch.test.api.userinfo.bean.UserInfoEntity;import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 9:24 2022/5/6
 * @Modified By :
 **/
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

    /**
     * 获取详情信息
     * @param id
     * @return
     */
    Map<String, Object> getInfo(@Param("id")Long id);

    /**
     * 分页查询
     * @return
     */
    List<UserInfoEntity> queryPage();
}
