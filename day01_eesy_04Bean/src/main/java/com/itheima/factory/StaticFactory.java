package com.itheima.factory;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/13
 */

import com.itheima.servicee.IAccountService;
import com.itheima.servicee.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类有可能存在jar包中，我们无法通过修改源码的方式来提供默认构造函数
 */
public class StaticFactory {
    public static IAccountService getAccountService(){

        return new AccountServiceImpl();
    }
}
