package com.ly.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.service.AnswerService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.AnswerVO;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @GetMapping("/answers/{currentPage}/{pageSize}")
    ResultVo findAllQuestion(@PathVariable("currentPage") Integer currentPage,
                             @PathVariable("pageSize") Integer pageSize){
        Page<AnswerVO> answerVOPage = new Page<>(currentPage,pageSize);
        IPage<AnswerVO> res = answerService.findAll(answerVOPage);
        return new ResultVo(ResultCode.SUCCESS,res);
    }
}
