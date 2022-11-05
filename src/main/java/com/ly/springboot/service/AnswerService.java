package com.ly.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.vo.AnswerVO;

public interface AnswerService {
    IPage<AnswerVO> findAll(Page<AnswerVO> page);
}
