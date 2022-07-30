package com.ly.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Admin {
    //id
    @TableId
    private Integer adminId;
    //姓名
    private String adminName;
    //性别
    private String sex;
    //电话
    private String tel;
    //邮箱
    private String email;
    //密码
    private String pwd;
    //身份证号
    private String cardId;
    //角色
    private String role;
}
