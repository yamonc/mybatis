package com.itheima.test;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/10
 */

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试CRUD
 */

public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
         in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3获取SqlSession对象
        sqlSession=factory.openSession();
        //获取代理对象
        userDao=sqlSession.getMapper(IUserDao.class);
    }
    @After//用于在执行方法之后执行
    public void destory() throws Exception{
        //需要提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
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
     * 测试使用QueryVo作为查询条件
     * @throws IOException
     */
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


    }
    /**
     * 查找
     * @throws IOException
     */
    @Test
    public void testFindByCondition() throws IOException {
        User u=new User();
        u.setUsername("老王");
        u.setSex("女");
        List<User> users=userDao.finUserByCondition(u);
        for (User user:users
        ) {
            System.out.println(user);

        }


    }
    /**
     * foreach标签 的使用
     * @throws IOException
     */
    @Test
    public void testFindInIds() throws IOException {
        QueryVo vo=new QueryVo();
        List<Integer> list=new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);
        vo.setIds(list);
        List<User> users=userDao.finUserInIds(vo);
        for (User user:users
        ) {
            System.out.println(user);

        }


    }


}
