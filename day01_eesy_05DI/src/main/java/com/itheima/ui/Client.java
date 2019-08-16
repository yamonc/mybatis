package com.itheima.ui;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */


import com.itheima.servicee.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟表现层用于调用业务层
 */
public class Client {

    public static void main(String[] args){
       //获取核心对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
                //根据id获取bean对象
        //两种方式：一种是转化成object对象然后强转，第二种是两个参数 直接转换为该对象
      /*  IAccountService as= (IAccountService) ac.getBean("accountService");
        System.out.println(as);

        as.saveAccount();*/
        /*IAccountService as= (IAccountService) ac.getBean("accountService2");
        System.out.println(as);
        as.saveAccount();*/
        IAccountService as= (IAccountService) ac.getBean("accountService3");
        System.out.println(as);
        as.saveAccount();




    }
}
