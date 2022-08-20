package com.ly.springboot.util;

import lombok.Getter;

@Getter
public enum ResultCode implements StatusCode{
    SUCCESS(200,"请求成功！"),
    FAILED(400,"请求失败！"),
    DATA_ERROR(402, "数据信息错误！"),
    RESPONSE_PACK_ERROR(403, "response返回包装失败");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
