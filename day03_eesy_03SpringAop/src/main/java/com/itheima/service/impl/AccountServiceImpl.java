package com.itheima.service.impl;

import com.itheima.service.IAccountService;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/19
 */

/**
 * 业务实现
 */
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updataAccount(int i) {
        System.out.println("执行了更新"+i);

    }

    public int deleteAccount() {
        System.out.println("删除操作 执行");
        return 0;
    }
}
