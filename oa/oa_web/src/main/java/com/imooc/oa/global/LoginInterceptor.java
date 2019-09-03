package com.imooc.oa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/31
 */

//防止未登录状态去访问别的资源
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url=httpServletRequest.getRequestURI();
        //得到路径
        if (url.toLowerCase().indexOf("login")>=0){
            //直接放行
            return true;
        }
        //剩下的都得登录方法，判断登录
        HttpSession session=httpServletRequest.getSession();
        if (session.getAttribute("employee")!=null){
            return true;
        }

        //从新登录
        httpServletResponse.sendRedirect("/to_login");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
