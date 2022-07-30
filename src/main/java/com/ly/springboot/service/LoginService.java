package com.ly.springboot.service;

import com.ly.springboot.entity.Admin;
import com.ly.springboot.entity.Student;
import com.ly.springboot.entity.Teacher;

public interface LoginService {
    //管理员登录
    Admin adminLogin(Integer username , String password);

    //教师登录
    Teacher teacherLogin(Integer username , String password);

    //学生登录
    Student studentLogin(Integer username , String password);
}
