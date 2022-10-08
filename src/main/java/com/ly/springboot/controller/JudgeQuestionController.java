package com.ly.springboot.controller;

import com.ly.springboot.entity.JudgeQuestion;
import com.ly.springboot.service.JudgeQuestionService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeQuestionController {

    @Autowired
    JudgeQuestionService judgeQuestionService;

    @GetMapping("/judgeQuestionId")
    ResultVo findOnlyQuestionId(){
        JudgeQuestion res = judgeQuestionService.findOnlyQuestionId();
        return new ResultVo(res);
    }

    @PostMapping("/judgeQuestion")
    ResultVo add(@RequestBody JudgeQuestion judgeQuestion){
        int res = judgeQuestionService.add(judgeQuestion);
        if (res != 0){
            return new ResultVo(res);
        }
        return new ResultVo(ResultCode.FAILED);
    }
}
