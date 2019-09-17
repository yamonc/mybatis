package com.imooc.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/29
 */

public class AuthenticationTest {
    SimpleAccountRealm simpleAccountRealm=new SimpleAccountRealm();
    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("mark","123456","admin","user");
    }
    @Test
    public void testAuthentication(){
        //构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject= SecurityUtils.getSubject();



        UsernamePasswordToken token=new UsernamePasswordToken("mark","123456");
        subject.login(token);

        System.out.println("isAuthenticated:"+subject.isAuthenticated());

        //认证完之后检查用户是否具备这样的角色
        subject.checkRoles("admin","user");
    }

}
