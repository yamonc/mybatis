package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/5
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */

    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
