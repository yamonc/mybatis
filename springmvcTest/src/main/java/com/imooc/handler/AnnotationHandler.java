package com.imooc.handler;

import com.imooc.entity.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/9/3
 */
@Controller
public class AnnotationHandler {

    /**
     * 业务方法：ModelAndView完成数据的传递和视图的解析
     */
    @RequestMapping("/model")
    public ModelAndView modelAndViewTest(){
        //创建ModelAndView对象
        ModelAndView modelAndView=new ModelAndView();
        //填充数据
        modelAndView.addObject("name","cym");
        //设置逻辑视图
        modelAndView.setViewName("show");
        return modelAndView;
    }

    /*
    * 业务方法：使用Model传值，String进行视图解析
    * */
    @RequestMapping("modelAndTest")
    public String modelTest(Model model){
        //填充模型数据
        model.addAttribute("name","yyh");
        //设置逻辑视图
        return "show";
    }
    /*
    * 业务方法：Map传值：String，进行视图解析
    * */
    @RequestMapping("map")
    public String MapTest(Map<String,String> map){
        //设置模型数据
        map.put("name","cymhhh");
        //设置逻辑视图
        return "show";

    }
    /**
     * 添加商品并展示
     */
    @RequestMapping("/addGoods")
    public ModelAndView addGoods(Goods goods){
        System.out.println(goods.toString());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("goods",goods);
        modelAndView.setViewName("show");
        return modelAndView;
    }

}
