package com.ch.mvc.exception;

import com.ch.common.base.BaseResEnum;
import com.ch.common.dto.ResultStatus;
import com.ch.common.exception.AppException;
import com.ch.common.util.UtilCollection;
import com.ch.common.util.UtilResult;
import com.ch.common.util.UtilString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import java.util.List;

/**
 * 请求参数值或后台数据保存时数据验证的错误
 *
 * @Author : liupeng
 * @Date : 2018/7/27 14:36
 * @Modified By
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionControllerAdvice {


    /**
     * 处理参数异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultStatus dealMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("请求参数异常，请求地址：{}", getReqUri(request));
        BindingResult bindingResult = e.getBindingResult();
        String msg = BaseResEnum.HTTP_STATUS_400.getMsg();
        if (bindingResult != null) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            if (CollectionUtils.isNotEmpty(allErrors)) {
                ObjectError objectError = allErrors.get(0);
                msg = objectError.getDefaultMessage();
            }
        }
        return UtilResult.getResultMessage(BaseResEnum.HTTP_STATUS_400.getCode(), msg);
    }


    /**
     * 处理参数异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultStatus dealMethodArgumentNotValidException(HttpMessageConversionException e, HttpServletRequest request) {
        log.error("请求参数转换失败，请求参数为空或格式错误，请求地址：{}，错误信息：{}", getReqUri(request), e.getMessage());
        return UtilResult.getResultStatus(BaseResEnum.HTTP_STATUS_400);
    }

    /**
     * 处理内部异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultStatus dealAppExcept(AppException exception, HttpServletRequest request) {
        log.error("内部处理异常，请求地址：{}，异常信息：", getReqUri(request), exception);
        return UtilResult.getResultMessage(exception.getErrorCode(), exception.getMessage());
    }

    /**
     * 错误的请求方式
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResultStatus delMethodNotSupportException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        log.error("错误的请求方式，请求地址：{}，请求方法：{}, 支持的请求方式：{}", request.getRequestURI(), e.getMethod(),
                UtilString.join(e.getSupportedMethods(), ","));
        return UtilResult.getResultStatus(BaseResEnum.HTTP_STATUS_405);
    }


    /**
     * 处理其他异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultStatus dealExcept(Exception exception, HttpServletRequest request) {
        log.error("内部处理异常，请求地址：{}，异常信息：", getReqUri(request), exception);
        return UtilResult.getFailStatus();
    }

    /**
     * 获取请求地址
     *
     * @param request
     * @return
     */
    private String getReqUri(HttpServletRequest request) {
        return request.getRequestURI();
    }
}