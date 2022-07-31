package com.ly.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.springboot.entity.Teacher;

public interface TeacherService extends IService<Teacher> {
    IPage<Teacher> selectAll(Page page);
}
