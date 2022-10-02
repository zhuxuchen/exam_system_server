package com.ly.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.ExamManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ExamManageMapper extends BaseMapper<ExamManage> {

    //分页查询
    @Select("select * from exam_manage")
    IPage<ExamManage> selectAll(Page page);

    //查询最后一条记录的paperId，返回给前端达到paperId自增的效果
    @Select("select paperId from exam_manage order by paperId desc limit 1")
    ExamManage findPaperId();
}
