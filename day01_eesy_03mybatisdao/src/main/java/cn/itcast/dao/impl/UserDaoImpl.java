package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/10
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    public List<User> findAll() {
        //使用工厂创建SqlSession对象
        SqlSession session=factory.openSession();
        //使用session查询所有方法
        List<User> users=session.selectList("cn.itcast.dao.UserDao.findAll");
        session.close();
        //返回查询结果
        return users;

    }
}
