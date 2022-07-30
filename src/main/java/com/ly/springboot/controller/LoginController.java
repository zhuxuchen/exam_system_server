package com.ly.springboot.controller;

import com.ly.springboot.entity.Admin;
import com.ly.springboot.entity.Login;
import com.ly.springboot.entity.Student;
import com.ly.springboot.entity.Teacher;
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
    String loginPage(@RequestBody Login login){
        Integer username = login.getUsername();
        String password = login.getPassword();
        Admin admin = loginService.adminLogin(username,password);
        if (admin != null){
            return "adminLogin!!";
        }
        Teacher teacher = loginService.teacherLogin(username,password);
        if (teacher != null){
            return "teacherLogin!!";
        }
        Student student = loginService.studentLogin(username,password);
        if (student != null){
            return "studentLogin!!";
        }
        return "error";
    }
}
