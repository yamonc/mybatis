package com.itheima.servicee.impl;


import com.itheima.servicee.IAccountService;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */
/*
账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
   // private IAccountDao accountDao= null;
  //  private IAccountDao accountDao= (IAccountDao) BeanFactory.getBean("accountDao");
    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");

    }
    public void init() {
        System.out.println("对象初试话");

    }
    public void destory() {
        System.out.println("destory");

    }
}
