package com.itheima.dao;

import com.itheima.domain.User;
import com.sun.javafx.image.IntPixelGetter;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/12
 */
/*在mybatis中crud有四个注解
* */
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",
                    fetchType = FetchType.LAZY))
    })
    List<User> findAll();



    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer userId);

    /**
     * 根据用户名模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    //@Select("select * from user where username like '%${value}%'")
    List<User> findByUserByName(String username);


}
