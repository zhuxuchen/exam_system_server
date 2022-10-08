package com.ly.springboot.controller;

import com.ly.springboot.entity.FillQuestion;
import com.ly.springboot.entity.JudgeQuestion;
import com.ly.springboot.entity.MultiQuestion;
import com.ly.springboot.entity.PaperManage;
import com.ly.springboot.service.FillQuestionService;
import com.ly.springboot.service.JudgeQuestionService;
import com.ly.springboot.service.MultiQuestionService;
import com.ly.springboot.service.PaperService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PaperController {
    @Autowired
    PaperService paperService;

    @Autowired
    MultiQuestionService multiQuestionService;

    @Autowired
    FillQuestionService fillQuestionService;

    @Autowired
    JudgeQuestionService judgeQuestionService;

    @GetMapping("/papers")
    ResultVo findAll(){
        List<PaperManage> res = paperService.findAll();
        if (res != null){
            return new ResultVo(res);
        }
        return new ResultVo(ResultCode.FAILED);
    }

    @PostMapping("/paperManage")
    ResultVo add(@RequestBody PaperManage paperManage){
        int res = paperService.add(paperManage);
        if (res != 0){
            return new ResultVo(res);
        }
        return new ResultVo(ResultCode.FAILED);
    }

    @GetMapping("/paper/{paperId}")
    Map<Integer, List<?>> findById(@PathVariable("paperId") Integer paperId){
        //选择题题库 1
        List<MultiQuestion> multiQuestionsRes = multiQuestionService.findByIdAndType(paperId);
        //填空题题库 2
        List<FillQuestion> fillQuestionsRes = fillQuestionService.findByIdAndType(paperId);
        //判断题题库 3
        List<JudgeQuestion> judgeQuestionsRes = judgeQuestionService.findByIdAndType(paperId);
        Map<Integer, List<?>> map = new HashMap<>();
        map.put(1, multiQuestionsRes);
        map.put(2, fillQuestionsRes);
        map.put(3, judgeQuestionsRes);
        return map;
    }
}
