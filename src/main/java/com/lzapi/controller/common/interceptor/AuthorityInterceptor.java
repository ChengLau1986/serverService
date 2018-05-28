package com.lzapi.controller.common.interceptor;

import com.lzapi.common.CodeMsg;
import com.lzapi.common.ResultMsg;
import com.lzapi.controller.common.annotation.LogDesc;
import com.lzapi.pojo.User;
import com.lzapi.util.CookieUtil;
import com.lzapi.util.JsonUtil;
import com.lzapi.util.RedisPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by lc on 2018/4/3.
 */
@Slf4j
public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("preHandle");
        //请求中Controller中的方法名
        HandlerMethod handlerMethod = (HandlerMethod)handler;

        //解析HandlerMethod

        String methodName = handlerMethod.getMethod().getName();
        String className = handlerMethod.getBean().getClass().getSimpleName();

        if(StringUtils.equals(className,"UserController") && StringUtils.equals(methodName,"Login")){
//            log.info("权限拦截器拦截到请求,className:{},methodName:{}",className,methodName);
            //如果是拦截到登录请求，不打印参数，因为参数里面有密码，全部会打印到日志中，防止日志泄露
            return true;
        }

        User user = null;

        String loginToken = CookieUtil.readLoginToken(request);
        if(StringUtils.isNotEmpty(loginToken)){
            String userJsonStr = RedisPoolUtil.get(loginToken);
            user = JsonUtil.string2Obj(userJsonStr,User.class);
        }

        if(user == null){
            //返回false.即不会调用controller里的方法
            response.reset();//geelynote 这里要添加reset，否则报异常 getWriter() has already been called for this response.
            response.setCharacterEncoding("UTF-8");//geelynote 这里要设置编码，否则会乱码
            response.setContentType("application/json;charset=UTF-8");//geelynote 这里要设置返回值的类型，因为全部是json接口。
            PrintWriter out = response.getWriter();

            out.print(JsonUtil.obj2String(ResultMsg.Error(CodeMsg.LOGIN_GQ)));
            out.flush();
            out.close();//geelynote 这里要关闭
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerMethod hm =  (HandlerMethod) handler;//将其强转过来
//        LogDesc record = hm.getMethod().getAnnotation(LogDesc.class);//拿到里面的自定义注解对象//通过反射
//        String actionType = record.actionType();//拿到自定义注解中的字段值 动作类型
//        String businessLogic = record.businessLogic();//拿到自定义注解中的字段值 业务逻辑
//        String str = "动作类型是:" + actionType + "  业务逻辑是:" + businessLogic;

//        response.reset();//geelynote 这里要添加reset，否则报异常 getWriter() has already been called for this response.
//        response.setCharacterEncoding("UTF-8");//geelynote 这里要设置编码，否则会乱码
//        response.setContentType("application/json;charset=UTF-8");//geelynote 这里要设置返回值的类型，因为全部是json接口。

//        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
