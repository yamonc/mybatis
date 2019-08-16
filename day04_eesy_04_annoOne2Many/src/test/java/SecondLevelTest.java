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
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/12
 */
public class SecondLevelTest {
    private InputStream in;
    private SqlSessionFactory factory;


    @Test
    public void testFindOne(){
         SqlSession session=factory.openSession();
         IUserDao userDao=session.getMapper(IUserDao.class);


        User user=userDao.findById(54);
        System.out.println(user);
        session.close();//释放一级缓存

       SqlSession session1=factory.openSession();//再次打开session
        IUserDao userdao1=session1.getMapper(IUserDao.class);
        User user1=userdao1.findById(54);
        System.out.println(user1);
        session1.close();


    }
}
