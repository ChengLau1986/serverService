package com.lzapi.controller.common;

import com.lzapi.common.CodeMsg;
import com.lzapi.common.Result;
import com.lzapi.util.FilterUtil;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Exrickx
 */
public class MyPermissionFilter extends AuthorizationFilter {

    private static final Logger log= LoggerFactory.getLogger(MyPermissionFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {

        Subject subject = this.getSubject(request, response);
        String[] perms = (String[]) ((String[]) o);
        boolean isPermitted = true;

        if (subject.getPrincipal() == null) {
            if(FilterUtil.isAjax(request)){
                log.info("未登录或登录时间过长,是ajax！");
            }else{
                log.info("未登录或登录时间过长,不是ajax！");
//                this.saveRequestAndRedirectToLogin(request, response);
            }

//            Map<String, Object> resultMap = new HashMap<String, Object>();
//            resultMap.put("code", CodeMsg.LOGIN_NONE.getCode());
//            resultMap.put("msg", CodeMsg.LOGIN_NONE.getMsg());
            FilterUtil.out(response, Result.Error(CodeMsg.LOGIN_NONE));
        } else {
            if (perms != null && perms.length > 0) {
                if (perms.length == 1) {
                    if (!subject.isPermitted(perms[0])) {
                        isPermitted = false;
                    }
                } else if (!subject.isPermittedAll(perms)) {
                    isPermitted = false;
                }
            }
            if (!isPermitted) {
                if (FilterUtil.isAjax(request)) {
                    log.info("没有该权限，并且是Ajax请求");
                } else {
                    log.info("没有该权限，不是Ajax请求");
//                    return isPermitted;
                }

//                Map<String, Object> resultMap = new HashMap<String, Object>();
//                resultMap.put("success", false);
//                resultMap.put("message", "抱歉，您没有该权限！看就看，你点它干什么...");
                FilterUtil.out(response, Result.Error(CodeMsg.Err_Perms));
            }
        }
        return isPermitted;
    }

}
