package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Executors;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/26
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行了");
        //从数据库中查询用户对象，存储并转发到
        User user=new User();
        user.setUsername("meimei");
        user.setPassword("123");
        user.setAge(30);

        model.addAttribute("user",user);

        return "success";
    }

    /**
     * 请求转发一次请求，不用编写项目的名称
     * 重定向需要项目的名称
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid");
        //编写请求转发的程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向的方式，两次请求
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        //直接进行相应
        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("你好");
        return ;

    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建modelAndView
        ModelAndView mv=new ModelAndView();

        System.out.println("testModelAndView");
        //从数据库中查询用户对象，存储并转发到
        User user=new User();
        user.setUsername("meimei");
        user.setPassword("222");
        user.setAge(30);
        //  把user对象存储到mv对象，会将user对象转存到request域当中
        mv.addObject("user",user);
        //跳转到那个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发和重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect");
        //转发
        //return "forward:/WEB-INF/pages/success.jsp";
        return "redircet:/index.jsp";
    }

    /**
     * 模拟异步请求和响应
     */
    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody String body){
        System.out.println("testAjax");
        System.out.println(body);


    }
}
