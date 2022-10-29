package com.ly.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.Score;
import com.ly.springboot.service.ScoreService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @GetMapping("/scores")
    ResultVo findAll(){
        List<Score> res = scoreService.list();
        return new ResultVo(res);
    }

    //分页
    @GetMapping("/score/{currentPage}/{pageSize}/{studentId}")
    ResultVo findById(@PathVariable("currentPage") Integer currentPage,
                      @PathVariable("pageSize") Integer pageSize,
                      @PathVariable("studentId") Integer studentId){

        Page<Score> scorePage = new Page<>(currentPage,pageSize);
        IPage<Score> res = scoreService.findByPageAndId(scorePage, studentId);
        return new ResultVo(res);
    }

    //不分页
    @GetMapping("/score/{studentId}")
    ResultVo findById(@PathVariable("studentId") Integer studentId){
        List<Score> res = scoreService.findById(studentId);
        if (res != null){
            return new ResultVo(res);
        }
        return new ResultVo(ResultCode.FAILED);
    }

    // 添加成绩
    @PostMapping("/score")
    ResultVo add(@RequestBody Score score){
        boolean res = scoreService.save(score);
        if (res){
            return new ResultVo(ResultCode.SUCCESS);
        }
        return new ResultVo(ResultCode.FAILED);
    }
}
