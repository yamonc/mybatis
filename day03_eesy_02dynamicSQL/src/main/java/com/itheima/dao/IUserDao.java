package com.itheima.dao;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/10
 */

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();


    User findById(Integer userId);
    /**
     * 根据名称模糊查询用户
     */
    List<User> findByName(String username);

    /**
     * 根据queryVo查询中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数调价
     */
    List<User> finUserByCondition(User user);

    /**
     * 根据querybo中提供的id集合查询用户信息
     * @param vo
     * @return
     */
    List<User> finUserInIds(QueryVo vo);
}
