//package com.lzapi.controller.common;
//
//import com.lzapi.common.CodeMsg;
//import com.lzapi.common.Result;
//import com.lzapi.util.JsonUtil;
//import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//
///**
// * @author: hxy
// * @description: 对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转login.jsp的拦截方式
// * 仅当配置loginurl的情况下，才会进入改页面。不适合前后端端分离情况
// * @date: 2017/10/24 10:11
// */
//public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {
//
//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        PrintWriter out = null;
//        HttpServletResponse res = (HttpServletResponse) response;
//        try {
//            res.setCharacterEncoding("UTF-8");
//            res.setContentType("application/json");
//            out = response.getWriter();
//            out.println(JsonUtil.obj2String(Result.Error(CodeMsg.LOGIN_NONE)));
//        } catch (Exception e) {
//        } finally {
//            if (null != out) {
//                out.flush();
//                out.close();
//            }
//        }
//        return false;
//    }
//}
