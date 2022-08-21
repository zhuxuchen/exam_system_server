package com.ly.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class ExamManage {
    @TableId
    private int examCode;

    private String description;

    private String source;

    private int paperId;

    private String examDate;

    private Integer totalTime;

    private String grade;

    private String term;

    private String major;

    private String institute;

    private Integer totalScore;

    private String type;

    private String tips;
}
