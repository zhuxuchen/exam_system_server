package com.ly.springboot.mapper;

import com.ly.springboot.entity.Admin;
import com.ly.springboot.entity.Student;
import com.ly.springboot.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    //管理员登录
    @Select("select adminId,adminName,sex,tel,email,cardId,role " +
            "from admin " +
            "where adminId = #{username} and pwd = #{password}")
    Admin adminLogin(@Param("username") Integer username ,@Param("password") String password);

    //教师登录
    @Select("select teacherId,teacherName,institute,sex,tel,email,cardId,type,role " +
            "from teacher " +
            "where teacherId = #{username} and pwd = #{password}")
    Teacher teacherLogin(@Param("username") Integer username ,@Param("password") String password);

    //学生登录
    @Select("select studentId,studentName,grade,major,clazz,institute,tel,email,cardId,sex,role " +
            "from student " +
            "where studentId = #{username} and pwd = #{password}")
    Student studentLogin(@Param("username") Integer username ,@Param("password") String password);
}
