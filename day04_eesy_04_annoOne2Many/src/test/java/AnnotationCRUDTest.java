import com.itheima.dao.IUserDao;
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
import java.util.Date;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/12
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession();
        userDao=session.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testFindAll(){
        List<User> users=userDao.findAll();

        for (User user :
                users) {
            System.out.println("---每个用户的信息---");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }


    @Test
    public void testFindOne(){
        User user=userDao.findById(54);
        System.out.println(user);

        User user1=userDao.findById(54);
        System.out.println(user1);

        System.out.println(user==user1);


    }
    @Test
    public void testFindByName(){
/*
        List<User> users=userDao.findByUserByName("%mybatis%");
*/
        List<User> users=userDao.findByUserByName("mybatis");

        for (User user :
                users) {
            System.out.println(user);
        }
    }


}
