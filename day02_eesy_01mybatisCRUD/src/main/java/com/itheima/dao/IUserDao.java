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

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);
    /**
     * 根据名称模糊查询用户
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo查询中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
