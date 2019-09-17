package com.itheima.service;

import com.itheima.domain.Account;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/20
 */
public interface IAccountService {

    Account findAccountById(Integer accountId);

    void transfer(String sourceName,String targetName,Float money);
}
