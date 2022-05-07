package com.ch.test.api.userinfo.service.impl;

import com.ch.common.base.AppBaseParams;
import com.ch.common.exception.AppException;
import com.ch.test.api.userinfo.bean.UserInfoEntity;
import com.ch.test.api.userinfo.mapper.UserInfoMapper;
import com.ch.test.api.userinfo.service.IUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 9:28 2022/5/6
 * @Modified By :
 **/
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoEntity getUserInfo(Long userId) {
        return userInfoMapper.selectById(userId);
    }

    @Override
    public Map<String, Object> getInfo(Long id) {
        return userInfoMapper.getInfo(id);
    }

    @Override
    public void saveInfo(UserInfoEntity info) {
        userInfoMapper.insert(info);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveInfo1(UserInfoEntity info) {
        userInfoMapper.insert(info);
        throw new AppException("1", "手动异常");
    }

    @Override
    public void updateInfo(UserInfoEntity info) {
        userInfoMapper.updateById(info);
    }

    @Override
    public void delInfo(Long id) {
        userInfoMapper.deleteById(id);
    }


    @Override
    public PageInfo<UserInfoEntity> getPageInfos(AppBaseParams params) {
        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<UserInfoEntity> userInfos = userInfoMapper.queryPage();
        PageInfo pageInfo = new PageInfo(userInfos);
        return pageInfo;
    }
}
