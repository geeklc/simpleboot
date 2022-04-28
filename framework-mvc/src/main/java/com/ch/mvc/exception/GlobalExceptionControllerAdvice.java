package com.ch.mvc.exception;

import com.ch.common.base.BaseResEnum;
import com.ch.common.dto.ResultStatus;
import com.ch.common.exception.AppException;
import com.ch.common.util.UtilCollection;
import com.ch.common.util.UtilResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
    public ResultStatus dealMethodArgumentNotValidException(MethodArgumentNotValidException e) {
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
     * 处理全部异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(AppException.class)
    public ResultStatus dealExcept(AppException exception) {
        log.error("", exception);
        return UtilResult.getResultMessage(exception.getErrorCode(), exception.getMessage());
    }

}