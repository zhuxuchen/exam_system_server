package com.ly.springboot.entity;

import lombok.Data;

@Data
//用于统一数据的返回值
public class ApiResult<T> {
    //状态码，成功为200，失败为400，错误为500
    private int code;
    //信息
    private String message;
    //数据
    private T data;

    public ApiResult() {
    }

    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
