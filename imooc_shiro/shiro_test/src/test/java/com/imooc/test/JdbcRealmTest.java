package com.imooc.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.sql.Driver;
import java.sql.SQLException;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/29
 */
public class JdbcRealmTest {

    DruidDataSource dataSource=new DruidDataSource();
    {

        dataSource.setUrl("jdbc:mysql//localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

    }

    public JdbcRealmTest() throws SQLException {
    }

    @Test
    public void testAuthentication(){

        JdbcRealm jdbcRealm=new JdbcRealm();

        jdbcRealm.setDataSource(dataSource);

        //构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);
        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("mark","123456");
        subject.login(token);

        System.out.println("isAuthenticated:"+subject.isAuthenticated());
        }
}
