package com.lzapi.controller.common.exception;

import com.lzapi.common.CodeMsg;

/**
 * Created by lc on 2018/7/3.
 */
public class MyException extends RuntimeException {

    private String msg;
    private int code;
    private String errInfo;

    public MyException(String msg){
        super(msg);
        this.msg=msg;
    }

    public MyException(CodeMsg msg){
        super(msg.getMsg());
        this.msg=msg.getMsg();
        this.code=msg.getCode();
    }

    public MyException(CodeMsg msg,String errInfo){
        super(msg.getMsg());
        this.msg=msg.getMsg();
        this.code=msg.getCode();
        this.errInfo = errInfo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrInfo() {
        return errInfo;
    }

    public void setErrInfo(String errInfo) {
        this.errInfo = errInfo;
    }

}
