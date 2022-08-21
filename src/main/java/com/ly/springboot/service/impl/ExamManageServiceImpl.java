package com.ly.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.springboot.entity.ExamManage;
import com.ly.springboot.mapper.ExamManageMapper;
import com.ly.springboot.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamManageServiceImpl extends ServiceImpl<ExamManageMapper, ExamManage>
        implements ExamManageService {

    @Autowired
    ExamManageMapper examManageMapper;

    @Override
    public IPage<ExamManage> selectAll(Page<ExamManage> page) {
        return examManageMapper.selectAll(page);
    }
}
