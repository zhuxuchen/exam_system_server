package com.ly.springboot.controller;

import com.ly.springboot.entity.PaperManage;
import com.ly.springboot.service.FillQuestionService;
import com.ly.springboot.service.JudgeQuestionService;
import com.ly.springboot.service.MultiQuestionService;
import com.ly.springboot.service.PaperService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.Item;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    MultiQuestionService multiQuestionService;

    @Autowired
    FillQuestionService fillQuestionService;

    @Autowired
    JudgeQuestionService judgeQuestionService;

    @Autowired
    PaperService paperService;

    @PostMapping("/item")
    ResultVo ItemController(Item item){
        // 选择题
        Integer changeNumber = item.getChangeNumber();
        // 填空题
        Integer fillNumber = item.getFillNumber();
        // 判断题
        Integer judgeNumber = item.getJudgeNumber();
        //出卷id
        Integer paperId = item.getPaperId();

        //选择题数据库获取
        List<Integer> changeNumbers = multiQuestionService.findBySubject(item.getSubject(), changeNumber);
        if (changeNumbers == null){
            return new ResultVo(ResultCode.FAILED, null);
        }
        for (Integer number : changeNumbers){
            PaperManage paperManage = new PaperManage(paperId,1,number);
            int index = paperService.add(paperManage);
            if (index == 0){
                return new ResultVo(400,"选择题组卷保存失败",null);
            }
        }

        //填空题数据库获取
        List<Integer> fills = fillQuestionService.findBySubject(item.getSubject(), fillNumber);
        if (fills == null){
            return new ResultVo(ResultCode.FAILED, null);
        }
        for (Integer fillNum : fills){
            PaperManage paperManage = new PaperManage(paperId,2,fillNum);
            int index = paperService.add(paperManage);
            if(index == 0){
                return new ResultVo(400,"填空题组卷保存失败",null);
            }
        }

        //判断题数据库获取
        List<Integer> judges = judgeQuestionService.findBySubject(item.getSubject(), judgeNumber);
        if (judges == null){
            return new ResultVo(ResultCode.FAILED, null);
        }
        for (Integer judge : judges){
            PaperManage paperManage = new PaperManage(paperId,3,judge);
            int index = paperService.add(paperManage);
            if(index == 0){
                return new ResultVo(400,"判断题组卷保存失败",null);
            }
        }

        return new ResultVo(ResultCode.SUCCESS);
    }
}
