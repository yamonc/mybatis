package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */
/**
 * 账户持久层实现类
 */
@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户11111111111111");
    }
}
