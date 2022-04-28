package com.ch.common.util;


import com.alibaba.fastjson2.JSON;
import com.ch.common.base.BaseResEnum;
import com.ch.common.base.ResStatusInterface;
import com.ch.common.dto.PageInfo;
import com.ch.common.dto.ResultData;
import com.ch.common.dto.ResultPage;
import com.ch.common.dto.ResultStatus;

import java.util.Date;
import java.util.List;

/**
 * @Author : lichong
 * @description :   获取返回相应实体类
 * @Date Create in 17:14 2017/11/30
 * @Modified By :
 **/
public interface UtilResult {

    /**
     * 根据参数获取状态实体
     * @param resStatusEnum
     * @return
     */
    static ResultStatus getResultStatus(ResStatusInterface resStatusEnum) {
        ResultStatus resultStatus = new ResultStatus();
        resultStatus.setCode(resStatusEnum.getCode());
        resultStatus.setMsg(resStatusEnum.getMsg());
        return resultStatus;
    }

    /**
     * 根据参数获取状态实体
     * @param
     * @return
     */
    static ResultStatus getFailStatus( ) {
        ResultStatus resultStatus = new ResultStatus();
        resultStatus.setCode(BaseResEnum.COMMON_FAIL.getCode());
        resultStatus.setMsg(BaseResEnum.COMMON_FAIL.getMsg());
        return resultStatus;
    }

    /**
     * 根据参数获取状态实体
     * @param msg
     * @return
     */
    static ResultStatus getFailStatus(String msg) {
        ResultStatus resultStatus = new ResultStatus();
        resultStatus.setCode(BaseResEnum.COMMON_FAIL.getCode());
        resultStatus.setMsg(msg);
        return resultStatus;
    }

    /**
     * 根据参数获取状态实体
     * @param
     * @return
     */
    static ResultStatus getSuccessStatus( ) {
        ResultStatus resultStatus = new ResultStatus();
        resultStatus.setCode(BaseResEnum.COMMON_SUCCESS.getCode());
        resultStatus.setMsg(BaseResEnum.COMMON_SUCCESS.getMsg());
        return resultStatus;
    }
    /**
     * 根据参数获取状态实体
     * @param
     * @return
     */
    static ResultStatus getSuccessStatus(String msg) {
        ResultStatus resultStatus = new ResultStatus();
        resultStatus.setCode(BaseResEnum.COMMON_SUCCESS.getCode());
        resultStatus.setMsg(msg);
        return resultStatus;
    }
    /**
     * 根据参数获取状态实体
     * @param code
     * @param message
     * @return
     */
    static ResultStatus getResultMessage(String code, String message) {
        ResultStatus resultStatus = new ResultStatus();
        resultStatus.setCode(code);
        resultStatus.setMsg(message);
        return resultStatus;
    }

    /**
     * 根据参数获取Object实体
     * @param resStatusEnum
     * @param object
     * @return
     */
    static <T> ResultData<T> getResultData(ResStatusInterface resStatusEnum, T object) {
        ResultData<T> resultObj = new ResultData();
        resultObj.setCode(resStatusEnum.getCode());
        resultObj.setMsg(resStatusEnum.getMsg());
        resultObj.setData(object);
        return resultObj;
    }

    /**
     * 根据参数获取Object实体
     * @param object
     * @return
     */
    static <T> ResultData<T> getResultSuccess (T object) {
        ResultData<T> resultObj = new ResultData();
        resultObj.setCode(BaseResEnum.COMMON_SUCCESS.getCode());
        resultObj.setMsg(BaseResEnum.COMMON_SUCCESS.getMsg());
        resultObj.setData(object);
        return resultObj;
    }

    /**
     * 获取pageInfo的参数实体
     * @param resStatusEnum
     * @param list
     * @param pageInfo
     * @return
     */
    static <T> ResultPage<T> getResultPageInfo(ResStatusInterface resStatusEnum, List<T> list, PageInfo pageInfo) {
        ResultPage<T> resultPageInfo = new ResultPage();
        resultPageInfo.setCode(resStatusEnum.getCode());
        resultPageInfo.setMsg(resStatusEnum.getMsg());
        resultPageInfo.setList(list);
        resultPageInfo.setPageInfo(pageInfo);
        return resultPageInfo;
    }


    /**
     * 获取pageInfo的参数实体
     * @param list
     * @param pageInfo
     * @return
     */
    static <T> ResultPage<T> getResultPageInfo(List<T> list, PageInfo pageInfo) {
        ResultPage<T> resultPageInfo = new ResultPage();
        resultPageInfo.setCode(BaseResEnum.COMMON_SUCCESS.getCode());
        resultPageInfo.setMsg(BaseResEnum.COMMON_SUCCESS.getMsg());
        resultPageInfo.setList(list);
        resultPageInfo.setPageInfo(pageInfo);
        return resultPageInfo;
    }

    /**
     * 返回列表
     * @param list
     * @return
     */
    static <T> ResultPage<T> getResultPageInfo( List<T> list) {
        ResultPage<T> resultPageInfo = new ResultPage();
        resultPageInfo.setCode(BaseResEnum.COMMON_SUCCESS.getCode());
        resultPageInfo.setMsg(BaseResEnum.COMMON_SUCCESS.getMsg());
        resultPageInfo.setList(list);
        return resultPageInfo;
    }

}
