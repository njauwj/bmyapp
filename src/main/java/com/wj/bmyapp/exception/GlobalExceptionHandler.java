package com.wj.bmyapp.exception;

import com.wj.bmyapp.resp.BaseResponse;
import com.wj.bmyapp.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wj
 * @create_time 2024/1/21
 * @description
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public BaseResponse<Object> businessExceptionHandler(BusinessException e) {
        log.error(e.getMsg());
        return ResultUtil.failed(e.getMsg());
    }

}
