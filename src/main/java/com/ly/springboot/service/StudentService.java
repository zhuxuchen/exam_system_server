package com.ly.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.Student;

public interface StudentService {
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
    Student selectById(int id);
    IPage<Student> selectList(Page<Student> page);
    int deleteById(int id);
    int updateById(Student student);
    int insert(Student student);
    int updatePwd(Student student);
}
