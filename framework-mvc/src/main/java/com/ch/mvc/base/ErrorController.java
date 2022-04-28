package com.ch.mvc.base;


import com.ch.common.base.BaseResEnum;
import com.ch.common.dto.ResultStatus;
import com.ch.common.util.UtilResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : lichong
 * @description : 错误的响应信息
 * @Date Create in 23:09 2019/1/12
 * @Modified By :
 **/
@RestController
public class ErrorController {

    /**
     * 请求参数错误
     * @return
     */
    @RequestMapping("/400")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultStatus errorFor400() {
        return UtilResult.getResultStatus(BaseResEnum.HTTP_STATUS_400);
    }

    /**
     * 认证失败
     * @return
     */
    @RequestMapping("/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultStatus errorFor401()  {
        return UtilResult.getResultStatus(BaseResEnum.HTTP_STATUS_401);
    }

    /**
     * 鉴权失败
     * @return
     */
    @RequestMapping("/403")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResultStatus errorFor403()  {
        return UtilResult.getResultStatus(BaseResEnum.HTTP_STATUS_403);
    }

    /**
     * 请求路径错误
     * @return
     */
    @RequestMapping("/404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultStatus errorFor404()  {
        return UtilResult.getResultStatus(BaseResEnum.HTTP_STATUS_404);
    }

    /**
     * 错误的请求方法
     * @return
     */
    @RequestMapping("/405")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResultStatus errorFor405() {
        return UtilResult.getResultStatus(BaseResEnum.HTTP_STATUS_405);
    }

    /**
     * 内部错误
     * @return
     */
    @RequestMapping("/500")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultStatus errorFor500() {
        return UtilResult.getResultStatus(BaseResEnum.HTTP_STATUS_500);
    }




}
