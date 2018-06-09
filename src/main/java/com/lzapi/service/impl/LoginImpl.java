package com.lzapi.service.impl;

import com.lzapi.dao.LoginDao;
import com.lzapi.pojo.User;
import com.lzapi.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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
            loginSuccess = false;
        }
        return loginSuccess;
    }

    @Override
    public User getUser(String username, String password){
        return loginDao.getUser(username, password);
    }
}
