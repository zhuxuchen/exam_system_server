package com.ly.springboot.controller;

import com.ly.springboot.entity.*;
import com.ly.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    ApiResult loginPage(@RequestBody Login login){
        Integer username = login.getUsername();
        String password = login.getPassword();
        Admin admin = loginService.adminLogin(username,password);
        if (admin != null){
            return new ApiResult<>(200,"请求成功！",admin);
        }
        Teacher teacher = loginService.teacherLogin(username,password);
        if (teacher != null){
            return new ApiResult<>(200,"请求成功！",teacher);
        }
        Student student = loginService.studentLogin(username,password);
        if (student != null){
            return new ApiResult<>(200,"请求成功！",student);
        }
        return new ApiResult<>(400,"请求失败！",null);
    }
}
