package com.ly.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.springboot.entity.Admin;
import com.ly.springboot.mapper.AdminMapper;
import com.ly.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
        implements AdminService {
    @Autowired
    AdminMapper adminMapper;
}
