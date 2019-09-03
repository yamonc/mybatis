package com.imooc.oa.dao;

import com.imooc.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/31
 */
@Repository("departmentDao")
public interface DepartmentDao {

    void insert(Department department);
    void update(Department department);
    void delete(String sn);
    Department select(String sn);
    List<Department> selectAll();
}
