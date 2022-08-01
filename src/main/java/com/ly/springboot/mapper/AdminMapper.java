package com.ly.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.springboot.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
