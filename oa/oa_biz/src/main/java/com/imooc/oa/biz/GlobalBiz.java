package com.imooc.oa.biz;

import com.imooc.oa.entity.Employee;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/31
 */

/**
 * 登录，退出放在表现层，不放在service层
 */
public interface GlobalBiz {

    Employee login(String sn,String password);
    void changePassword(Employee employee);
}
