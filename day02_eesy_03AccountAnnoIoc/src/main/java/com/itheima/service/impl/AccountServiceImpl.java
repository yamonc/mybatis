package com.itheima.service.impl;

import com.itheima.damain.Account;
import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */

/*
账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    /*因为只有唯一的对象所有用*/
    @Autowired
    private IAccountDao accountDao;


    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
