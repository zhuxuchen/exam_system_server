package com.ly.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Teacher {
    //id
    @TableId(type = IdType.AUTO)
    private Integer teacherId;
    //姓名
    private String teacherName;
    //学院
    private String institute;
    //性别
    private String sex;
    //电话
    private String tel;
    //邮件
    private String email;
    //密码
    private String pwd;
    //身份证号
    private String cardId;
    //职称
    private String type;
    //角色
    private String role;
}
