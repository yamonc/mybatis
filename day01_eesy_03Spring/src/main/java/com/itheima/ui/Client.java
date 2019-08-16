package com.itheima.ui;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */

import com.itheima.dao.IAccountDao;
import com.itheima.servicee.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 模拟表现层用于调用业务层
 */
public class Client {
    /**
     * 获取spring的ioc容器，并且根据id获取对象
     * @param args
     * ApplicationContext的三个常用实现类：
     *      （常用）ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在就不行
     *      FIleSystemApplicationContext：它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext：它是读取注解创建容器
     * 核心容器的两个额接口引发的问题
     *      ApplicationContext：单例对象使用
     *          它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说，已读取完配置文件，就马上创建配置文件中配置的对象
     *      BeanFactory： 多例对象适用
     *          它在创建核心 容器是：采用延迟加载的方式，什么时候根据id获取对象了，什么时候才真正创建对象
     */
    public static void main(String[] args){
       //获取核心对象
        ApplicationContext ac=new FileSystemXmlApplicationContext("C:\\Users\\陈亚萌\\Desktop\\bean.xml");
        //根据id获取bean对象
        //两种方式：一种是转化成object对象然后强转，第二种是两个参数 直接转换为该对象
        IAccountService as= (IAccountService) ac.getBean("accountService");
        IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);
        as.saveAccount();
       //------BeanFac-----
     /*   Resource resource=new ClassPathResource("bean.xml");
        BeanFactory factory;
        factory = new XmlBeanFactory(resource);
        IAccountService as= (IAccountService) factory.getBean("accountService");
        System.out.println(as);*/


    }
}
