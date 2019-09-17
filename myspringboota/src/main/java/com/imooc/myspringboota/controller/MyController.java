package com.imooc.myspringboota.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/9/1
 */
@Controller
public class MyController {
    //value注解是在启动时，自动扫描yml文件，将key值注入进来
    @Value("${mall.config.name}")
    private String name;
    @Value("${mall.config.description}")
    private String description;
    @Value("${mall.config.hot-sales}")
    private Integer hosSales;
    @Value("${mall.config.show-advert}")
    private Boolean showAdvert;

    @RequestMapping("/out")
    @ResponseBody
    public String out(){
        return "success";
    }
    @RequestMapping("/info")
    @ResponseBody
    public String info(){
        return String.format("name:%s,description:%s,hot-sales:%s,show-advert:%s",
                name,description,hosSales,showAdvert
                );

    }
}
