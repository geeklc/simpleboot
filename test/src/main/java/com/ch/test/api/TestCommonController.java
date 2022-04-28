package com.ch.test.api;

import com.ch.common.dto.ResultStatus;
import com.ch.common.exception.AppException;
import com.ch.common.util.UtilResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author : lichong
 * @description :
 * @Date Create in 16:10 2022/4/27
 * @Modified By :
 **/
@RequestMapping("/api/common")
@RestController
@Slf4j
public class TestCommonController {

    @GetMapping("log")
    public String getStr(String name) {
        log.debug("--------------------  debug -------------------");
        log.info("====================  info ====================");
        log.error("++++++++++++++++++++  error +++++++++++++++++++++");
        log.info("name:{}", name);
        return name;
    }


    @PostMapping("user")
    public ResultStatus getUser(@Valid @RequestBody User user) {
        if ("1".equals(user.getUserId())) {
            throw new AppException("1", "用户id错误");
        }
        return UtilResult.getResultSuccess(user);
    }

}
