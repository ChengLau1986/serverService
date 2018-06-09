package com.lzapi.common;

/**
 * Created by lc on 2018/3/27.
 */
public enum CodeMsg {
    SUCCESS(1,"SUCCESS"),
    ERROR(0,"ERROR"),
    LOGIN_ERROR(100,"用户名或密码错误"),
    LOGIN_NONE(101,"用户未登录或登录过期,无法获取当前用户的信息");


    private int code;
    private String msg;

    CodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return  this.code;
    }
    public String getMsg(){
        return  this.msg;
    }

}
