package com.ly.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.ExamManage;
import com.ly.springboot.service.ExamManageService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamManageController {
    @Autowired
    ExamManageService examManageService;

    //根据ID查询考试信息
    @GetMapping("/exam/{id}")
    ResultVo selectById(@PathVariable int id){
        ExamManage examManage = examManageService.getById(id);
        if (examManage != null){
            return new ResultVo(examManage);
        }
        return new ResultVo(ResultCode.FAILED);
    }

    //查询所有考试信息
    @GetMapping("/exams")
    ResultVo selectAll(){
        List<ExamManage> examManages = examManageService.list();
        if (examManages != null){
            return new ResultVo(examManages);
        }
        return new ResultVo(ResultCode.FAILED);
    }

    //查询分页考试信息
    @GetMapping("/exam/{currentPage}/{pageSize}")
    ResultVo findAll(@PathVariable("currentPage") int currentPage,
                     @PathVariable("pageSize") int pageSize){
        Page<ExamManage> examManagePage = new Page<>(currentPage,pageSize);
        IPage<ExamManage> examManage = examManageService.selectAll(examManagePage);
        return new ResultVo(examManage);
    }

    //根据id删除考试信息
    @DeleteMapping("/exam/{id}")
    ResultVo deleteById(@PathVariable int id){
        boolean res = examManageService.removeById(id);
        if (res){
            return new ResultVo(200,"删除成功！", true);
        }
        return new ResultVo(400,"删除失败！", false);
    }

    //更新考试信息
    @PutMapping("/exam")
    ResultVo updateById(@RequestBody ExamManage examManage){
        boolean res = examManageService.updateById(examManage);
        if (res){
            return new ResultVo(200,"更新成功！", true);
        }
        return new ResultVo(400,"更新失败！", false);
    }

    //添加考试信息
    @PostMapping("/exam")
    ResultVo insert(@RequestBody ExamManage examManage){
        boolean res = examManageService.save(examManage);
        if (res){
            return new ResultVo(200,"添加成功！", true);
        }
        return new ResultVo(400,"添加失败！", false);
    }

    @GetMapping("/paperId")
    ResultVo findPaperId(){
        ExamManage res = examManageService.findPaperId();
        if (res != null){
            return new ResultVo(res);
        }
        return new ResultVo(ResultCode.FAILED);
    }
}
