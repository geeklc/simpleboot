package com.ch.test.api.userinfo.service;

import com.ch.common.base.AppBaseParams;
import com.ch.test.api.userinfo.bean.UserInfoEntity;
import com.ch.test.api.userinfo.mapper.UserInfoMapper;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 9:27 2022/5/6
 * @Modified By :
 **/
public interface IUserInfoService {

    /**
     * 获取用户id
     *
     * @param userId
     * @return
     */
    UserInfoEntity getUserInfo(Long userId);

    /**
     * 获取信息详情
     *
     * @param id
     * @return
     */
    Map<String, Object> getInfo(Long id);

    /**
     * 保存信息
     *
     * @param info
     */
    void saveInfo(UserInfoEntity info);

    /**
     * 修改信息
     *
     * @param info
     */
    void updateInfo(UserInfoEntity info);

    /**
     * 删除信息
     *
     * @param id
     */
    void delInfo(Long id);

    /**
     * 获取分页信息
     */
    PageInfo<UserInfoEntity> getPageInfos(AppBaseParams params);
}
