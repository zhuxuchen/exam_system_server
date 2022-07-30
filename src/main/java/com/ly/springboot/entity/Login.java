package com.ly.springboot.entity;

import lombok.Data;

@Data
public class Login {
    //用于将用户名和密码打包成JSON方便传值
    private Integer username;
    private String password;
}
