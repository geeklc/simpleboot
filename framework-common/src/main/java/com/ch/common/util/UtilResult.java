package com.ch.common.util;


import com.ch.common.base.BaseResEnum;
import com.ch.common.base.ResStatusInterface;
import com.ch.common.common.AppConstants;
import com.ch.common.dto.PageInfo;
import com.ch.common.dto.ResultData;
import com.ch.common.dto.ResultPage;
import com.ch.common.dto.ResultStatus;

import java.util.List;

/**
 * @Author : lichong
 * @description :   获取返回相应实体类
 * @Date Create in 17:14 2017/11/30
 * @Modified By :
 **/
public class UtilResult {

    /**
     * 根据参数获取状态实体
     * @param resStatusEnum
     * @return
     */
    public static ResultStatus getResultStatus(ResStatusInterface resStatusEnum) {
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
    public static ResultStatus getFailStatus( ) {
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
    public static ResultStatus getFailStatus(String msg) {
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
    public static ResultStatus getSuccessStatus( ) {
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
    public static ResultStatus getSuccessStatus(String msg) {
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
    public static ResultStatus getResultMessage(String code, String message) {
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
    public static <T> ResultData<T> getResultData(ResStatusInterface resStatusEnum, T object) {
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
    public static <T> ResultData<T> getResultSuccess (T object) {
        ResultData<T> resultObj = new ResultData();
        resultObj.setCode(BaseResEnum.COMMON_SUCCESS.getCode());
        resultObj.setMsg(BaseResEnum.COMMON_SUCCESS.getMsg());
        resultObj.setData(object);
        return resultObj;
    }

    /**
     * 获取pageInfo的参数实体
     * @param resStatusEnum
     * @param pageInfo
     * @return
     */
    public static <T> ResultPage<T> getResultPageInfo(ResStatusInterface resStatusEnum,PageInfo pageInfo) {
        ResultPage<T> resultPageInfo = new ResultPage();
        resultPageInfo.setCode(resStatusEnum.getCode());
        resultPageInfo.setMsg(resStatusEnum.getMsg());
        resultPageInfo.setPageInfo(pageInfo);
        return resultPageInfo;
    }


    /**
     * 获取pageInfo的参数实体
     * @param pageInfo
     * @return
     */
    public static <T> ResultPage<T> getResultPageInfo(PageInfo pageInfo) {
        ResultPage<T> resultPageInfo = new ResultPage();
        resultPageInfo.setCode(BaseResEnum.COMMON_SUCCESS.getCode());
        resultPageInfo.setMsg(BaseResEnum.COMMON_SUCCESS.getMsg());
        resultPageInfo.setPageInfo(pageInfo);
        return resultPageInfo;
    }

    /**
     * 返回列表
     * @param list
     * @return
     */
    public static <T> ResultPage<T> getResultPageInfo( List<T> list) {
        ResultPage<T> resultPageInfo = new ResultPage();
        resultPageInfo.setCode(BaseResEnum.COMMON_SUCCESS.getCode());
        resultPageInfo.setMsg(BaseResEnum.COMMON_SUCCESS.getMsg());
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(list.size());
        pageInfo.setTotalPages(1);
        pageInfo.setTotalRows(Long.valueOf(list.size()));
        pageInfo.setPageNum(AppConstants.DEFAULT_PAGE_NUM);
        pageInfo.setList(list);
        resultPageInfo.setPageInfo(pageInfo);
        return resultPageInfo;
    }

}
