package com.lzapi.service;

import com.lzapi.common.ResultMsg;
import com.lzapi.pojo.User;

import java.util.Map;

/**
 * Created by lc on 2018/3/25.
 */
public interface IUserService {
    ResultMsg<Map<String,Object>> checkUser(String userid, String password);
}
