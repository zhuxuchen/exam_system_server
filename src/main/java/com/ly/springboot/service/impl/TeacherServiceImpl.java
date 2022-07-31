package com.ly.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.springboot.entity.Teacher;
import com.ly.springboot.mapper.TeacherMapper;
import com.ly.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
        implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public IPage<Teacher> selectAll(Page page) {
        return teacherMapper.selectAll(page);
    }
}
