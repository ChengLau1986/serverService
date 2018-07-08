package com.lzapi.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;

/**
 * Created by lc on 2018/3/25.
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class Result<T> implements Serializable{
    private int code;
    private String msg;
    private  T result;

    private Result(int status){
        this.code = status;
    }
    private Result(int status, T result){
        this.code = status;
        this.result = result;
    }

    private Result(int status, String msg, T result){
        this.code = status;
        this.msg = msg;
        this.result = result;
    }

    private Result(int status, String msg){
        this.code = status;
        this.msg = msg;
    }

    public int getCode(){
        return code;
    }
    public T getResult(){
        return result;
    }
    public String getMsg(){
        return msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.code == CodeMsg.SUCCESS.getCode();
    }

    public static <T> Result<T> Success(){
        return new Result<T>(CodeMsg.SUCCESS.getCode(),CodeMsg.SUCCESS.getMsg());
    }

    public static <T> Result<T> Success(CodeMsg msg, T result){
        return  new Result<T>(msg.getCode(),msg.getMsg(),result);
    }

    public static <T> Result<T> SuccessData(T result){
        return new Result<T>(CodeMsg.SUCCESS.getCode(),CodeMsg.SUCCESS.getMsg(),result);
    }

    public static <T> Result<T> SuccessMsg(String msg){
        return new Result<T>(CodeMsg.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> Error(CodeMsg msg){
        return  new Result<T>(msg.getCode(),msg.getMsg());
    }

    public static <T> Result<T> Error(CodeMsg msg,T result){
        return  new Result<T>(msg.getCode(),msg.getMsg(),result);
    }

}
