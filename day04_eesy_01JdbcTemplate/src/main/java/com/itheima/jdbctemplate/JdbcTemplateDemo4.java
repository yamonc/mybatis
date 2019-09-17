package com.itheima.jdbctemplate;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/19
 */

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        IAccountDao accountDao= ac.getBean("accountDao",IAccountDao.class);
        Account account=accountDao.findAccountById(1);
        System.out.println(account);

        account.setMoney(10002f);
        accountDao.updateAccount(account);

    }
}
