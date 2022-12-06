package com.ly.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.Student;
import com.ly.springboot.service.StudentService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    //根据id查询学生信息
    @GetMapping("/student/{id}")
    ResultVo selectById(@PathVariable int id){
        Student student = studentService.selectById(id);
        if (student != null){
            return new ResultVo(student);
        }
        return new ResultVo(ResultCode.FAILED);
    }

    //查询全部学生信息带分页
    @GetMapping("/students/{currentPage}/{pageSize}")
    ResultVo findAll(@PathVariable int currentPage,@PathVariable int pageSize){
        Page<Student> studentPage = new Page<>(currentPage,pageSize);
        IPage<Student> student = studentService.selectList(studentPage);
        return new ResultVo(student);
    }

    //根据id删除学生信息
    @DeleteMapping("/student/{id}")
    ResultVo deleteById(@PathVariable int id){
        int res = studentService.deleteById(id);
        if (res != 0){
            return new ResultVo(200,"删除成功！",res);
        }
        return new ResultVo(400,"删除失败！",res);
    }

    //更新学生信息
    @PutMapping("/student")
    ResultVo updateById(@RequestBody Student student){
        int res = studentService.updateById(student);
        if (res != 0){
            return new ResultVo(200,"更新成功！",res);
        }
        return new ResultVo(400,"更新失败！",res);
    }

    //添加学生信息
    @PostMapping("/student")
    ResultVo insert(@RequestBody Student student){
        int res = studentService.insert(student);
        if (res != 0){
            return new ResultVo(200,"添加成功！",res);
        }
        return new ResultVo(400,"添加失败！",res);
    }

    //更新学生密码
    @PutMapping("/studentpwd")
    ResultVo updatePwd(@RequestBody Student student){
        int res = studentService.updatePwd(student);
        if (res != 0){
            return new ResultVo(200,"密码更新成功！",res);
        }
        return new ResultVo(400,"密码更新失败！",res);
    }
}
