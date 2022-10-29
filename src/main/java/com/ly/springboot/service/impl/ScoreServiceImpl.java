package com.ly.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.springboot.entity.Score;
import com.ly.springboot.mapper.ScoreMapper;
import com.ly.springboot.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
        implements ScoreService{

    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public IPage<Score> findByPageAndId(Page page, Integer studentId) {
        return scoreMapper.findByPageAndId(page, studentId);
    }

    @Override
    public List<Score> findById(Integer studentId) {
        return scoreMapper.findById(studentId);
    }
}
