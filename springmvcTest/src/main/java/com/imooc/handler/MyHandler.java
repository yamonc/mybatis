package com.imooc.handler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/9/3
 */
public class MyHandler implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        //装在模型数据和逻辑视图
        ModelAndView modelAndView=new ModelAndView();
        //添加模型数据
        modelAndView.addObject("name","tom");
        //添加逻辑视图
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
