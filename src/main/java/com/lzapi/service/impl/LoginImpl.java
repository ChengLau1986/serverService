package com.lzapi.service.impl;

import com.lzapi.common.CodeMsg;
import com.lzapi.common.Result;
import com.lzapi.controller.common.exception.MyException;
import com.lzapi.dao.LoginDao;
import com.lzapi.pojo.User;
import com.lzapi.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by lc on 2018/6/7.
 */
@Service
public class LoginImpl implements LoginService{

    @Autowired
    private LoginDao loginDao;

    @Override
    public boolean authLogin(String username,String password) {
        boolean loginSuccess =false;
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            loginSuccess = true;
        } catch (AuthenticationException e) {
            throw new MyException(CodeMsg.LOGIN_ERROR,e.getMessage());
        }
        return loginSuccess;
    }

    @Override
    public User getUser(String username, String password){
        return loginDao.getUser(username, password);
    }

    @Override
    public Result<String> logout(){
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
            return Result.Error(CodeMsg.ERROR,e.toString());
        }
        return Result.Success();
    }
}
