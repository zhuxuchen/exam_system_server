package com.ly.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    /*
    使用MybatisPlus提供的增删改查方法
    1、根据id查询学生信息
    selectById(id)
    2、查询所有学生信息
    selectList()
    3、根据id删除学生信息
    deleteById()
    4、更新学生信息
    updateById(student)
    5、添加学生信息
    insert(student)
     */

    //更改学生密码
    @Update("update student set pwd = #{pwd} where studentId = #{studentId}")
    int updatePwd(Student student);
}
