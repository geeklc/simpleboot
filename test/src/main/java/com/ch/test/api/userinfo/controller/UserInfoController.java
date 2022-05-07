package com.ch.test.api.userinfo.controller;

import com.ch.common.base.AppBaseParams;
import com.ch.common.dto.ResultStatus;
import com.ch.common.util.UtilResult;
import com.ch.test.api.BaseController;
import com.ch.test.api.userinfo.bean.UserInfoEntity;
import com.ch.test.api.userinfo.service.IUserInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 9:37 2022/5/6
 * @Modified By :
 **/
@RequestMapping("api/userinfo")
@RestController
public class UserInfoController extends BaseController {

    @Autowired
    private IUserInfoService userInfoService;

    @PostMapping("save")
    public ResultStatus save(@Valid @RequestBody UserInfoEntity info) {
        userInfoService.saveInfo(info);
        return UtilResult.getSuccessStatus();
    }

    @PostMapping("save1")
    public ResultStatus save1(@Valid @RequestBody UserInfoEntity info) {
        userInfoService.saveInfo1(info);
        return UtilResult.getSuccessStatus();
    }


    @PostMapping("info/{id}")
    public ResultStatus getInfo(@PathVariable Long id) {
        UserInfoEntity userInfo = userInfoService.getUserInfo(id);
        return UtilResult.getResultSuccess(userInfo);
    }

    @PostMapping("info1/{id}")
    public ResultStatus getInfo1(@PathVariable Long id) {
        Map<String,Object> userInfo = userInfoService.getInfo(id);
        return UtilResult.getResultSuccess(userInfo);
    }

    @PostMapping("update")
    public ResultStatus update(@Valid @RequestBody UserInfoEntity info) {
        userInfoService.updateInfo(info);
        return UtilResult.getSuccessStatus();
    }


    @PostMapping("del/{id}")
    public ResultStatus update(@PathVariable Long id) {
        userInfoService.delInfo(id);
        return UtilResult.getSuccessStatus();
    }

    @PostMapping("page")
    public ResultStatus getInfo(@RequestBody AppBaseParams params) {
        PageInfo<UserInfoEntity> pageInfos = userInfoService.getPageInfos(params);
        return getResultPageInfo(pageInfos);
    }
}
