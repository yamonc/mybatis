package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/9
 */

/*
* 用户持久层*/
public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();
}
