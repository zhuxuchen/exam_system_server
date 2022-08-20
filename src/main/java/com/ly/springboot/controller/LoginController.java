package com.ly.springboot.controller;

import com.ly.springboot.entity.*;
import com.ly.springboot.service.LoginService;
import com.ly.springboot.util.ResultCode;
import com.ly.springboot.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    ResultVo loginPage(@RequestBody Login login){
        Integer username = login.getUsername();
        String password = login.getPassword();
        Admin admin = loginService.adminLogin(username,password);
        if (admin != null){
            return new ResultVo(admin);
        }
        Teacher teacher = loginService.teacherLogin(username,password);
        if (teacher != null){
            return new ResultVo(teacher);
        }
        Student student = loginService.studentLogin(username,password);
        if (student != null){
            return new ResultVo(student);
        }
        return new ResultVo(ResultCode.FAILED);
    }
}
