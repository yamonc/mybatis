package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/11
 */
public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
