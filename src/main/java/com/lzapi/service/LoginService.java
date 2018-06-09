package com.lzapi.service;

import com.lzapi.pojo.User;

/**
 * Created by lc on 2018/6/7.
 */
public interface LoginService {
    boolean authLogin(String username,String password);
    User getUser(String username,String password);
}
