package com.ly.springboot.controller;

import com.ly.springboot.entity.FillQuestion;
import com.ly.springboot.service.FillQuestionService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FillQuestionController {

    @Autowired
    FillQuestionService fillQuestionService;

    @GetMapping("/fillQuestionId")
    ResultVo findOnlyQuestion(){
        FillQuestion res = fillQuestionService.findOnlyQuestionId();
        return new ResultVo(res);
    }

    @PostMapping("/fillQuestion")
    ResultVo add(@RequestBody FillQuestion fillQuestion){
        int res = fillQuestionService.add(fillQuestion);
        if (res != 0){
            return new ResultVo(res);
        }
        return new ResultVo(ResultCode.FAILED);
    }
}
