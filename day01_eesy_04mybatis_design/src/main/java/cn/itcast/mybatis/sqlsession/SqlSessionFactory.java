package cn.itcast.mybatis.sqlsession;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/10
 */
public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();


}
