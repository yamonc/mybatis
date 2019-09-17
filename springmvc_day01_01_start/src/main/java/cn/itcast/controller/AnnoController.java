package cn.itcast.controller;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/26
 */

import cn.itcast.domain.User;
import jdk.nashorn.internal.objects.annotations.SpecializedFunction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="name") String username){
    System.out.println("执行了");
        System.out.println(username);
        return "success";
    }
    /**
     * 获取到请求体的内容
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }

    /**
     * pathvariable注解
     */
    @RequestMapping(value = "/testPathVariable/{sid}" )
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println("执行了cookie");
        System.out.println(cookie);
        return "success";
    }
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了");
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法课一先执行

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行");
        //通过用户名查询数据库
        User user=new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
     */
    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行");
        //通过用户名查询数据库
        User user=new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);

    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes");
        //底层会存储到request域中
        model.addAttribute("msg","meimei");
        return "success";
    }
}
