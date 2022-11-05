package com.ly.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.springboot.entity.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

    // 分页
    @Select("select scoreId,examCode,studentId,subject,ptScore,etScore,score,answerDate" +
            " from score where studentId = #{studentId} order by scoreId desc")
    IPage<Score> findByPageAndId(Page page,@Param("studentId") Integer studentId);

    // 不分页
    @Select("select scoreId,examCode,studentId,subject,ptScore,etScore,score,answerDate" +
            " from score where studentId = #{studentId}")
    List<Score> findById(Integer studentId);

    // 查询每位学生的学科分数
    @Select("select max(etScore) as etScore from score " +
            "where examCode = #{examCode} group by studentId")
    List<Score> findByExamCode(Integer examCode);
}
