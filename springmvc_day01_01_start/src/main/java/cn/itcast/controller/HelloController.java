package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/21
 */
//控制器类
@Controller
@RequestMapping(path = "/user")
public class HelloController {
    /*表示请求的路径*/
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello springmvc");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(path = "/testRequestMapping",method = {RequestMethod.POST})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解...");
        return "success";
    }

}
