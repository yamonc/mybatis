package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.GlobalBiz;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/31
 */
@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
    //根据用户提交过来的用户名，来查找用户信息
        Employee employee=employeeDao.select(sn);
        if (employee!=null && employee.getPassword().equals(password)){
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
