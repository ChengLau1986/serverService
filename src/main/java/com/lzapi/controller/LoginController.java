package com.lzapi.controller;

import com.lzapi.common.CodeMsg;
import com.lzapi.common.Result;
import com.lzapi.service.LoginService;
import com.lzapi.vo.LoginVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lc on 2018/6/7.
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    @ResponseBody
    public Result authLogin(@RequestBody LoginVo loginInfo) {
        String username = loginInfo.getUsername();
        String password = loginInfo.getPassword();
        boolean isSuccess = loginService.authLogin(username,password);
        if(isSuccess){
            return Result.SuccessMsg("登录成功!");
        }else {
            return Result.Error(CodeMsg.LOGIN_ERROR);
        }
    }


//    @RequiresPermissions("role:list")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public Result test() {
        return Result.SuccessMsg("测试成功!");
    }
}
