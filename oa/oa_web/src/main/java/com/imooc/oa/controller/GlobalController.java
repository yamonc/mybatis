package com.imooc.oa.controller;

import com.imooc.oa.biz.GlobalBiz;
import com.imooc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/31
 */
@Controller("globalController")
public class GlobalController {
    @Autowired
    private GlobalBiz globalBiz;
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String sn, @RequestParam String password){
        Employee employee=globalBiz.login(sn,password);
        if (employee==null){
            return "redirect:to_login";
        }
        session.setAttribute("employee",employee);
        return "redirect:self";

    }
    //登录成功后查看个人信息
    @RequestMapping("/self")
    public String self(){
        return "self";
    }
    //退出登录
    @RequestMapping("/quit")
    public String logout(HttpSession session){

        session.setAttribute("employee",null);
        return "redirect:/to_login";

    }
    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }
    @RequestMapping("/change_password")
    public String changePassword(HttpSession session,@RequestParam String old,@RequestParam String new1,@RequestParam String new2 ){
        Employee empolyee = (Employee) session.getAttribute("employee");
        if (empolyee.getPassword().equals(old)){
            //两次修改的密码是否一致
            if (new1.equals(new2)){
                empolyee.setPassword(new1);
                globalBiz.changePassword(empolyee);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password";
    }

}
