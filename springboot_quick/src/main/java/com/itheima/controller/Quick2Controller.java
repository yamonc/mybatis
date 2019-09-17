package com.itheima.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/28
 */
@Controller
public class Quick2Controller {

    @Value("${name}")
    private String name;
    @RequestMapping("/quick2")
    @ResponseBody
    public String quick2(){
        //获得配置文件的信息

        return "name:"+name;
    }
}
