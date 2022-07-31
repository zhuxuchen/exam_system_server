package com.ly.springboot;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.Student;
import com.ly.springboot.mapper.LoginMapper;
import com.ly.springboot.mapper.StudentMapper;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    StudentMapper studentMapper;

    @Test
    void loginTest() {
        //loginMapper.teacherLogin(20081001,"123456");
        //loginMapper.adminLogin(9527,"123456");
        loginMapper.studentLogin(20154001,"123456");
    }

    @Test
    void studentTest(){
//        Student student = new Student();
//        student.setStudentId(20000);
//        student.setStudentName("123");
//        studentMapper.insert(student);
//        System.out.println(studentMapper.selectList(null));
//        System.out.println(studentMapper.selectById(20154001));
//        studentMapper.deleteById()
//        studentMapper.updateById(student);
        IPage<Student> page = new Page<Student>(1,5);
        System.out.println(page);
    }
}
