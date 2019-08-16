package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/11
 */
public class UserDaoImpl  implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }
    public List<User> findAll() {
        //1.根据factory火球SqlSession对象
        SqlSession session=factory.openSession();
        //调用Sqlsession方法
        List<User> users = session.selectList("com.itheima.dao.IUserDao.findAll");//参数就是能获取配置信息的key

        //释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //实现保存
        session.insert("com.itheima.dao.IUserDao.saveUser",user);
        //提交事务
        session.commit();
        //释放资源
        session.close();


    }

    public void updateUser(User user) {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //实现保存
        session.update("com.itheima.dao.IUserDao.updateUser",user);
        //提交事务
        session.commit();
        //释放资源
        session.close();

    }

    public void deleteUser(Integer userId) {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //实现保存
        session.update("com.itheima.dao.IUserDao.deleteUser",userId);
        //提交事务
        session.commit();
        //释放资源
        session.close();

    }

    public User findById(Integer userId) {
        //1.根据factory火球SqlSession对象
        SqlSession session=factory.openSession();
        //调用Sqlsession方法查询一个
        User users = session.selectOne("com.itheima.dao.IUserDao.findById",userId);//参数就是能获取配置信息的key

        //释放资源
        session.close();
        return users;

    }

    public List<User> findByName(String username) {
        //1.根据factory火球SqlSession对象
        SqlSession session=factory.openSession();
        //调用Sqlsession方法
        List<User> users = session.selectList("com.itheima.dao.IUserDao.findByName",username);//参数就是能获取配置信息的key

        //释放资源
        session.close();
        return users;

    }

    public int findTotal() {
        //1.根据factory火球SqlSession对象
        SqlSession session=factory.openSession();
        //调用Sqlsession方法
        Integer count = session.selectOne("com.itheima.dao.IUserDao.findTotal");//参数就是能获取配置信息的key

        //释放资源
        session.close();
        return count;

    }
}
