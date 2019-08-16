package com.itheima.ui;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */

import com.itheima.dao.IAccountDao;
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
       IAccountService as= (IAccountService) ac.getBean("accountService");
       // IAccountService as2= (IAccountService) ac.getBean("accountService");

        /*System.out.println(as);

        IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);
        System.out.println(adao);*/
        as.saveAccount();
       /* System.out.println(as==as2);*/

    }
}
