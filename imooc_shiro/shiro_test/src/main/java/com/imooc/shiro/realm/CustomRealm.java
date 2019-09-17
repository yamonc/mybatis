package com.imooc.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/29
 */
public class CustomRealm extends AuthorizingRealm {
    Map<String,String> userMap=new HashMap<String, String>(16);
    {
        userMap.put("mark","73bea81c6c06bacab41a995495239545");
        super.setName("customRealm");
    }
//授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName= (String) principalCollection.getPrimaryPrincipal();
        //从数据库或者缓存中获取角色数据
        Set<String> roles=getRolesByUserName(userName);
        Set<String> permissions=getPermissionByUserName(userName);

        //返回
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }

    private Set<String> getPermissionByUserName(String userName) {
        Set<String> sets=new HashSet<String>();
        sets.add("user:delete");
        sets.add("user:add");
        return sets;
    }

    private Set<String> getRolesByUserName(String userName) {
        Set<String> sets=new HashSet<String>();
        sets.add("admin");
        sets.add("user");
        return sets;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从主体传过来的认证信息中获得用户名
        String username= (String) authenticationToken.getPrincipal();
        //通过用户名到数据库中获取凭证
        String password=getPasswordByUserName(username);
        if (password==null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo("mark",password,"customRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("mark"));
        return authenticationInfo;
    }

    /**
     * ，模拟数据库
     * @param username
     * @return
     */
    private String getPasswordByUserName(String username) {

        return userMap.get(username);
    }

    public static void main(String[] args) {
        Md5Hash md5Hash=new Md5Hash("123456","mark");
        System.out.println(md5Hash);
    }
}
