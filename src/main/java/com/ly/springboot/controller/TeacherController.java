package com.ly.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.ApiResult;
import com.ly.springboot.entity.Teacher;
import com.ly.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    //根据id查询老师信息
    @GetMapping("/teacher/{id}")
    ApiResult selectById(@PathVariable int id){
        Teacher teacher = teacherService.getById(id);
        if (teacher != null){
            return new ApiResult(200,"查询成功！",teacher);
        }
        return new ApiResult(404,"查询的用户不存在!",null);
    }

    //查询全部教师信息带分页
    @GetMapping("/teacher/{currentPage}/{pageSize}")
    ApiResult findAll(@PathVariable int currentPage,@PathVariable int pageSize){
        Page<Teacher> teacherPage = new Page<>(currentPage,pageSize);
        IPage<Teacher> teacher = teacherService.selectAll(teacherPage);
        return new ApiResult(200,"分页查询所有老师^_^",teacher);
    }

    //根据id删除老师信息
    @DeleteMapping("/teacher/{id}")
    ApiResult deleteById(@PathVariable int id){
        boolean res = teacherService.removeById(id);
        if (res){
            return new ApiResult(200,"删除成功！",res);
        }
        return new ApiResult(404,"删除失败！",res);
    }

    //更新学生信息
    @PutMapping("/teacher")
    ApiResult updateById(@RequestBody Teacher teacher){
        boolean res = teacherService.updateById(teacher);
        if (res){
            return new ApiResult(200,"更新成功！",res);
        }
        return new ApiResult(400,"更新失败！",res);
    }

    //添加老师信息
    @PostMapping("/teacher")
    ApiResult insert(@RequestBody Teacher teacher){
        boolean res = teacherService.save(teacher);
        if (res){
            return new ApiResult(200,"添加成功！",res);
        }
        return new ApiResult(400,"添加失败！",res);
    }
}
