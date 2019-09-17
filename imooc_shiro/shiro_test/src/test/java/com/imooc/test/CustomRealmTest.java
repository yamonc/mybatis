package com.imooc.test;

import com.imooc.shiro.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/29
 */
public class CustomRealmTest {



    @Test
    public void testAuthentication(){
        CustomRealm customRealm=new CustomRealm();

        //构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        //设置加密
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
        //设置加密的名称
        matcher.setHashAlgorithmName("md5");
        //设置加密的次数
        matcher.setHashIterations(1);

        customRealm.setCredentialsMatcher(matcher);


        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("mark","123456");
        subject.login(token);

        System.out.println("isAuthenticated:"+subject.isAuthenticated());

        subject.checkRole("admin");
        subject.checkPermissions("user:add","user:delete");

    }
}
