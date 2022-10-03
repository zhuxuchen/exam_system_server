package com.ly.springboot.mapper;

import com.ly.springboot.entity.PaperManage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PaperMapper {
    // 查询全部
    @Select("select paperId, questionType, questionId  from paper_manage")
    List<PaperManage> findAll();

    // 根据id查询
    @Select("select paperId, questionType, questionId  from paper_manage where paperId = #{paperId}")
    List<PaperManage> findById(Integer paperId);

    @Insert("insert into paper_manage(paperId,questionType,questionId) values " +
            "(#{paperId},#{questionType},#{questionId})")
    int add(PaperManage paperManage);
}
