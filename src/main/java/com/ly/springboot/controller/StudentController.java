package com.ly.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.ApiResult;
import com.ly.springboot.entity.Student;
import com.ly.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    //根据id查询学生信息
    @GetMapping("/student/{id}")
    ApiResult selectById(@PathVariable int id){
        Student student = studentService.selectById(id);
        if (student != null){
            return new ApiResult(200,"查询成功！",student);
        }
        return new ApiResult(404,"查询的用户不存在!",null);
    }

    //查询全部学生信息带分页
    @GetMapping("/student/{currentPage}/{pageSize}")
    ApiResult findAll(@PathVariable int currentPage,@PathVariable int pageSize){
        Page<Student> studentPage = new Page<>(currentPage,pageSize);
        IPage<Student> student = studentService.selectList(studentPage);
        return new ApiResult(200,"分页查询所有学生^_^",student);
    }

    //根据id删除学生信息
    @DeleteMapping("/student/{id}")
    ApiResult deleteById(@PathVariable int id){
        int res = studentService.deleteById(id);
        if (res != 0){
            return new ApiResult(200,"删除成功！",res);
        }
        return new ApiResult(404,"删除失败！",res);
    }

    //更新学生信息
    @PutMapping("/student")
    ApiResult updateById(@RequestBody Student student){
        int res = studentService.updateById(student);
        if (res != 0){
            return new ApiResult(200,"更新成功！",res);
        }
        return new ApiResult(400,"更新失败！",res);
    }

    //添加学生信息
    @PostMapping("/student")
    ApiResult insert(@RequestBody Student student){
        int res = studentService.insert(student);
        if (res != 0){
            return new ApiResult(200,"添加成功！",res);
        }
        return new ApiResult(400,"添加失败！",res);
    }

    //更新学生密码
    @PutMapping("/studentpwd")
    ApiResult updatePwd(@RequestBody Student student){
        int res = studentService.updatePwd(student);
        if (res != 0){
            return new ApiResult(200,"密码更新成功！",res);
        }
        return new ApiResult(400,"密码更新失败！",res);
    }
}
