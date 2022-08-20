package com.ly.springboot.util;

import com.ly.springboot.vo.ResultVo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler({DuplicateKeyException.class})
    //过滤添加用户时id重复的异常
    public ResultVo DuplicateKeyExceptionHandler(DuplicateKeyException e){
        return new ResultVo(ResultCode.DATA_ERROR,"添加成员的id重复！");
    }
}
