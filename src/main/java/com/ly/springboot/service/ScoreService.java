package com.ly.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.springboot.entity.Score;

import java.util.List;

public interface ScoreService extends IService<Score> {

    IPage<Score> findByPageAndId(Page page, Integer studentId);

    List<Score> findById(Integer studentId);
}
