package cn.itcast.mybatis.sqlsession.defaults;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/10
 */

import cn.itcast.mybatis.cfg.Configuration;
import cn.itcast.mybatis.sqlsession.SqlSession;
import cn.itcast.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }
    /**
     *用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {

        return new DefaultSqlSession(cfg);
    }
}
