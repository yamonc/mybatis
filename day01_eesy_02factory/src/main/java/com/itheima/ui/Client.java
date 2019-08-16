package com.itheima.ui;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.factory.BeanFactory;
import com.itheima.servicee.IAccountService;
import com.itheima.servicee.impl.AccountServiceImpl;

/**
 * 模拟表现层用于调用业务层
 */
public class Client {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        IAccountService as= (IAccountService) BeanFactory.getBean("accountService");
       as.saveAccount();
    }
}
