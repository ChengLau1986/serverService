package com.lzapi.controller.common;

import com.lzapi.common.CodeMsg;
import com.lzapi.common.Result;
import com.lzapi.util.FilterUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lc on 2018/7/3.
 */
@Slf4j
    public class SystemLogoutFilter extends LogoutFilter {
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        //在这里执行退出系统前需要清空的数据

        Subject subject = getSubject(request, response);
//      String redirectUrl = getRedirectUrl(request, response, subject);
        try {
            subject.logout();
            FilterUtil.out(response, Result.SuccessMsg("退出登录"));

        } catch (SessionException ise) {
            log.error("退出失败:"+ise.toString());
            ise.printStackTrace();
            FilterUtil.out(response, Result.Error(CodeMsg.Err_LOGOUT,ise.toString()));
        }

//        issueRedirect(request, response, redirectUrl);
        //返回false表示不执行后续的过滤器，直接返回跳转到登录页面
        return false;

    }
}
