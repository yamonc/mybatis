package com.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/9
 */
/*入门*/
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SQLSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);

        //使用工厂创建dao的对象
        UserDao userDao=new UserDaoImpl(factory);


        //使用代理对象执行方法
        List<User> users=userDao.findAll();
        for (User user :
                users) {
            System.out.println(user);
        }
        //释放资源
        in.close();
    }
}
