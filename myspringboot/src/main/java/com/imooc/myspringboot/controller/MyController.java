package com.imooc.myspringboot.controller;

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

    @RequestMapping("/out")
    @ResponseBody
    public String out(){
        return "success";
    }

}
