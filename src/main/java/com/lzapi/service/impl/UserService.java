package com.lzapi.service.impl;

import com.lzapi.common.CodeMsg;
import com.lzapi.common.Const;
import com.lzapi.common.ResultMsg;
import com.lzapi.controller.common.annotation.LogDesc;
import com.lzapi.dao.UserMapper;
import com.lzapi.pojo.User;
import com.lzapi.service.IUserService;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;
import java.util.UUID;

/**
 * Created by lc on 2018/3/25.
 */
@Service
//@Scope("prototype")
//@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.INTERFACES)
public class UserService implements IUserService {
    @Autowired
    private UserMapper mapper;

    @LogDesc(actionType = "登陆",businessLogic = "用户")
    @Override
    public ResultMsg<Map<String,Object>> checkUser(String userid, String password){
        Map<String,Object> user = mapper.checkUser(userid,password);
        if(user!=null){
            String userKey = UUID.randomUUID().toString();
            user.put(Const.TOKEN_NAME,userKey);
            return  ResultMsg.Success(user);
        }
        else {
            return ResultMsg.Error(CodeMsg.LOGIN_ERROR);
        }
    }
}
