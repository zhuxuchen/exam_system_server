package com.ly.springboot;

import com.ly.springboot.mapper.LoginMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    LoginMapper loginMapper;
    @Test
    void loginTest() {
        //loginMapper.teacherLogin(20081001,"123456");
        //loginMapper.adminLogin(9527,"123456");
        loginMapper.studentLogin(20154001,"123456");
    }

}
