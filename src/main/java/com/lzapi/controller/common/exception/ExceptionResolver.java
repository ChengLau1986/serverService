package com.lzapi.controller.common.exception;

import com.lzapi.common.CodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lc
 * 返回简单的异常，不需要提供完整异常信息
 */
@Slf4j
@Component
public class ExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.error("{} Exception",httpServletRequest.getRequestURI(),e);
        ModelAndView modelAndView = new ModelAndView(new MappingJacksonJsonView());

        //shiro过滤器已经拦截
//        if(e instanceof UnauthenticatedException){
//            modelAndView.addObject("code",CodeMsg.LOGIN_NONE.getCode());
//            modelAndView.addObject("msg",CodeMsg.LOGIN_NONE.getMsg());
//        }else if(e instanceof UnknownAccountException){
//            modelAndView.addObject("code",CodeMsg.Err_USER.getCode());
//            modelAndView.addObject("msg",CodeMsg.Err_USER.getMsg());
//        }else if (e instanceof IncorrectCredentialsException){
//            modelAndView.addObject("code",CodeMsg.Err_PWD.getCode());
//            modelAndView.addObject("msg",CodeMsg.Err_PWD.getMsg());
//        }
        if(e instanceof MyException) {
            modelAndView.addObject("code",((MyException) e).getCode());
            modelAndView.addObject("msg",((MyException) e).getMsg());
            modelAndView.addObject("errInfo",((MyException) e).getErrInfo());
        } else{
            modelAndView.addObject("code",CodeMsg.ERROR.getCode());
            modelAndView.addObject("msg",CodeMsg.ERROR.getMsg());
            modelAndView.addObject("errInfo",e.getMessage());
        }
        return modelAndView;
    }
}
