package com.ly.springboot.controller;

import com.ly.springboot.entity.PaperManage;
import com.ly.springboot.service.PaperService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaperController {
    @Autowired
    PaperService paperService;

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
}
