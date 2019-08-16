import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/12
 */
public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //获取字节输入流
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //根据字节输入流构建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //根据SqlSessionFactory生产一个SqlSession
        SqlSession session=factory.openSession();

        //使用SqlSession获取dao代理对象
        IUserDao userDao=session.getMapper(IUserDao.class);
        //执行dao方法
        List<User> users=userDao.findAll();
        for (User user :
                users) {
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
    }
}
