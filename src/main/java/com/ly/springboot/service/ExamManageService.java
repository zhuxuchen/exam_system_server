package com.ly.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.springboot.entity.ExamManage;

public interface ExamManageService extends IService<ExamManage> {

    //分页查询所有考试信息
    IPage<ExamManage> selectAll(Page<ExamManage> page);
}
