package com.imooc.oa.dao;

import com.imooc.oa.entity.Department;
import com.imooc.oa.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/31
 */
@Repository("employeeDao")
public interface EmployeeDao {

    void insert(Employee employee);
    void update(Employee employee);
    void delete(String sn);
    Employee select(String sn);
    List<Employee> selectAll();
}
