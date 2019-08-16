package com.itheima.servicee.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.factory.BeanFactory;
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
    //private IAccountDao accountDao= new AccountDaoImpl();
    private IAccountDao accountDao= (IAccountDao) BeanFactory.getBean("accountDao");

    public AccountServiceImpl() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    }

    public void saveAccount() {
        accountDao.saveAccount();

    }
}
