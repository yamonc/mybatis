package com.imooc.oa.biz;

import com.imooc.oa.entity.Department;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/31
 */
public interface DepartmentBiz {

    void add(Department department);
    void edit(Department department);
    void remove(String sn);
    Department get(String sn);
    List<Department> getAll();

}
