package com.lzapi.controller;

import com.lzapi.common.CodeMsg;
import com.lzapi.common.Const;
import com.lzapi.common.Result;
import com.lzapi.controller.common.exception.MyException;
import com.lzapi.service.LoginService;
import com.lzapi.util.JsonUtil;
import com.lzapi.util.RedisPoolUtil;
import com.lzapi.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public Result<String> authLogin(@Valid @RequestBody LoginVo loginInfo, BindingResult result, HttpSession session) {
        String username = loginInfo.getUsername();
        String password = loginInfo.getPassword();
        loginService.authLogin(username,password);
        return Result.SuccessMsg(session.getId());
    }


//    @RequiresPermissions("user:update")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public Result<String> test() throws InterruptedException {
        return Result.SuccessMsg("测试成功!");
    }

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> getUserInfo(HttpSession session){
        String userInfo = RedisPoolUtil.get(Const.USER_INFO+session.getId());
        if(null==userInfo){
            throw new MyException("没有登录");
        }else {
            return Result.SuccessData(userInfo);
        }
    }


    //logout直接走filter，不走url匹配了
//    @RequestMapping(value = "/logout",method = RequestMethod.POST)
//    public Result<String> logout(){
//        return loginService.logout();
//    }
}
