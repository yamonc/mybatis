package com.imooc.oa.biz;

import com.imooc.oa.entity.Department;
import com.imooc.oa.entity.Employee;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/31
 */
public interface EmployeeBiz {

    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();

}
