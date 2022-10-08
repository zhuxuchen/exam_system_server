package com.ly.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.FillQuestion;
import com.ly.springboot.mapper.FillQuestionMapper;
import com.ly.springboot.service.FillQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FillQuestionServiceImpl implements FillQuestionService {

    @Autowired
    FillQuestionMapper fillQuestionMapper;

    @Override
    public List<FillQuestion> findByIdAndType(Integer paperId) {
        return fillQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public IPage<FillQuestion> findAll(Page<FillQuestion> page) {
        return fillQuestionMapper.findAll(page);
    }

    @Override
    public FillQuestion findOnlyQuestionId() {
        return fillQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public int add(FillQuestion fillQuestion) {
        return fillQuestionMapper.add(fillQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return fillQuestionMapper.findBySubject(subject, pageNo);
    }
}
