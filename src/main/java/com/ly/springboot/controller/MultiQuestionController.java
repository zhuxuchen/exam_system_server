package com.ly.springboot.controller;

import com.ly.springboot.entity.MultiQuestion;
import com.ly.springboot.service.MultiQuestionService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MultiQuestionController {

    @Autowired
    MultiQuestionService multiQuestionService;

    @GetMapping("/multiQuestionId")
    ResultVo findOnlyQuestion(){
        MultiQuestion res = multiQuestionService.findOnlyQuestionId();
        return new ResultVo(res);
    }

    @PostMapping("/multiQuestion")
    ResultVo add(@RequestBody MultiQuestion multiQuestion){
        int res = multiQuestionService.add(multiQuestion);
        if (res != 0){
            return new ResultVo(res);
        }
        return new ResultVo(ResultCode.FAILED);
    }
}
