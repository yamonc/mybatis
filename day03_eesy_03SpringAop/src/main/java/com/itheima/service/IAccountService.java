package com.itheima.service;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/19
 */

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新用户
     * @param i
     */
    void updataAccount(int i);

    /**
     * 删除账户
     * @return
     */
    int deleteAccount();
}
