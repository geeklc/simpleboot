package com.ch.mvc.base;

import com.ch.common.dto.ResultStatus;
import com.ch.common.util.UtilResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : lichong
 * @description :  获取健康检查接口
 * @Date Create in 9:49 2022/4/29
 * @Modified By :
 **/

@RequestMapping("api/health")
@RestController
public class HealthCheckController {


    @RequestMapping("check")
    public ResultStatus getCheckInfo() {
        return UtilResult.getSuccessStatus();
    }
}
