package com.itheima.test;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/10
 */

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试CRUD
 */

public class MybatisTest {
    private InputStream in;

    private IUserDao userDao;
    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
         in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3使用工厂对象 创建dao对象
        userDao=new UserDaoImpl(factory);


    }
    @After//用于在执行方法之后执行
    public void destory() throws Exception{

        in.close();
    }
    /**
     * 查询所有
     */
    @Test
    public void testFindAll() throws IOException {

        //查询所有方法
        List<User> users=userDao.findAll();
        for (User user :
                users) {
            System.out.println(user);
            
        }

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() throws IOException {
        User user=new User();
        user.setUsername("dao impl user to save ");
        user.setAddress("邯郸市");
        user.setSex("男");
        user.setBirthday(new Date());

        System.out.println("保存操作之前"+user);
        userDao.saveUser(user);

        System.out.println("保存操作之后"+user);


    }
    /**
     * 更新用户
     */
    @Test
    public void testUpdate() throws IOException {
        User user=new User();
        user.setId(51);
        user.setUsername("mybatis update");
        user.setAddress("邯郸市");
        user.setSex("女");
        user.setBirthday(new Date());


        userDao.updateUser(user);


    }
    /**
     * 删除
     */
    @Test
    public void testDelete() throws IOException {



        userDao.deleteUser(53);


    }

    /**
     * 根据id查找
     * @throws IOException
     */
    @Test
    public void testFindOne() throws IOException {


        User user = userDao.findById(48);
        System.out.println(user);


    }
    /**
     * 根据姓名模糊查找
     * @throws IOException
     */
    @Test
    public void testFindByName() throws IOException {

        List<User> users=userDao.findByName("%王%");
        //List<User> users=userDao.findByName("王");
        for(User user:users){
            System.out.println(user);

        }


    }
    /**
     * 查询总记录条数
     * @throws IOException
     */
    @Test
    public void testFindTotal() throws IOException {

        int count=userDao.findTotal();
        System.out.println(count);


    }

 /*   *//**
     * 测试使用QueryVo作为查询条件
     * @throws IOException
     *//*
    @Test
    public void testFindByVo() throws IOException {
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users=userDao.findUserByVo(vo);
        //List<User> users=userDao.findByName("王");
        for(User u:users){
            System.out.println(u);

        }


    }*/
}
