package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/12
 */
public interface IAccountDao {
    /**
     * 查询所有账户，并且获取每个账户下的所述用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap" ,value={
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one=@One(select="com.itheima.dao.IUserDao.findById",fetchType= FetchType.EAGER))

    })
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountByUid(Integer uid);
}

