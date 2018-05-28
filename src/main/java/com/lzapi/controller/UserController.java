package com.lzapi.controller;

import com.lzapi.common.CodeMsg;
import com.lzapi.common.Const;
import com.lzapi.common.ResultMsg;
import com.lzapi.controller.common.annotation.LogDesc;
import com.lzapi.pojo.LoginUser;
import com.lzapi.pojo.User;
import com.lzapi.service.IUserService;
import com.lzapi.util.CookieUtil;
import com.lzapi.util.JsonUtil;
import com.lzapi.util.RedisPoolUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by lc on 2018/3/25.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Callable<ResultMsg<Map<String,Object>>> Login(@RequestBody final User user, final HttpServletResponse servletResponse, final HttpSession session) {
        return new Callable<ResultMsg<Map<String,Object>>>() {
            @Override
            public ResultMsg<Map<String,Object>> call() throws Exception {
                ResultMsg<Map<String,Object>> userResult = userService.checkUser(user.getAccount(), user.getUserpwd());
                String token =userResult.getResult().get(Const.TOKEN_NAME).toString();
                if(userResult.isSuccess()) {
                    CookieUtil.writeLoginToken(servletResponse,token,Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
                    RedisPoolUtil.setEx(token, JsonUtil.obj2String(userResult.getResult()), Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
                }
                return userResult;
            }
        };
    }

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    @ResponseBody
    public Callable<ResultMsg<User>> GetInfo(final HttpServletRequest request){
        return new Callable<ResultMsg<User>>() {
            @Override
            public ResultMsg<User> call() throws Exception {
                String loginToken = CookieUtil.readLoginToken(request);
                String userJsonStr = RedisPoolUtil.get(loginToken);
                User user = JsonUtil.string2Obj(userJsonStr,User.class);

                if(user != null){
                    return ResultMsg.Success(user);
                }
                return ResultMsg.Error(CodeMsg.LOGIN_GQ);
            }
        };
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public Callable<ResultMsg<String>> logout(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse,final HttpSession session) {
        return new Callable<ResultMsg<String>>() {
            @Override
            public ResultMsg<String> call() throws Exception {
//                session.invalidate();
                String loginToken = CookieUtil.readLoginToken(httpServletRequest);
                CookieUtil.delLoginToken(httpServletRequest, httpServletResponse);
                RedisPoolUtil.del(loginToken);

//        session.removeAttribute(Const.CURRENT_USER);

                return ResultMsg.Success();
            }
        };
    }
}
