package com.itheima.servicee.impl;

import com.itheima.dao.IAccountDao;
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
    private IAccountDao accountDao= null;
  //  private IAccountDao accountDao= (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();

    }
}
