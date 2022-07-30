package com.ly.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.springboot.entity.Admin;
import com.ly.springboot.entity.Student;
import com.ly.springboot.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    //管理员登录
    @Select("select * from admin where adminId = #{username} and pwd = #{password}")
    Admin adminLogin(@Param("username") Integer username ,@Param("password") String password);

    //教师登录
    @Select("select * from teacher where teacherId = #{username} and pwd = #{password}")
    Teacher teacherLogin(@Param("username") Integer username ,@Param("password") String password);

    //学生登录
    @Select("select * from student where studentId = #{username} and pwd = #{password}")
    Student studentLogin(@Param("username") Integer username ,@Param("password") String password);
}
