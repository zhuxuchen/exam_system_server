package com.ly.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.Teacher;
import com.ly.springboot.service.TeacherService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    //根据id查询老师信息
    @GetMapping("/teacher/{id}")
    ResultVo selectById(@PathVariable int id){
        Teacher teacher = teacherService.getById(id);
        if (teacher != null){
            return new ResultVo(teacher);
        }
        return new ResultVo(ResultCode.FAILED);
    }

    //查询全部教师信息带分页
    @GetMapping("/teacher/{currentPage}/{pageSize}")
    ResultVo findAll(@PathVariable int currentPage,@PathVariable int pageSize){
        Page<Teacher> teacherPage = new Page<>(currentPage,pageSize);
        IPage<Teacher> teacher = teacherService.selectAll(teacherPage);
        return new ResultVo(teacher);
    }

    //根据id删除老师信息
    @DeleteMapping("/teacher/{id}")
    ResultVo deleteById(@PathVariable int id){
        boolean res = teacherService.removeById(id);
        if (res){
            return new ResultVo(200,"删除成功！", true);
        }
        return new ResultVo(400,"删除失败！", false);
    }

    //更新老师信息
    @PutMapping("/teacher")
    ResultVo updateById(@RequestBody Teacher teacher){
        boolean res = teacherService.updateById(teacher);
        if (res){
            return new ResultVo(200,"更新成功！", true);
        }
        return new ResultVo(400,"更新失败！", false);
    }

    //添加老师信息
    @PostMapping("/teacher")
    ResultVo insert(@RequestBody Teacher teacher){
        boolean res = teacherService.save(teacher);
        if (res){
            return new ResultVo(200,"添加成功！", true);
        }
        return new ResultVo(400,"添加失败！", false);
    }
}
