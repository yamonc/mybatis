package com.itheima.dao;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/20
 */

import com.itheima.domain.Account;

/**
 * 账户持久层接口
 */
public interface IAccountDao {
    /**
     * 根据id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 跟新账户
     * @param account
     */
    void updateAccount(Account account);
}
