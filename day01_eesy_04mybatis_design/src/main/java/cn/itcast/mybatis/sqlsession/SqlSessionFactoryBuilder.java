package cn.itcast.mybatis.sqlsession;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/10
 */

import cn.itcast.mybatis.cfg.Configuration;
import cn.itcast.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import cn.itcast.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg= XMLConfigBuilder.loadConfiguration(config);

        return new DefaultSqlSessionFactory(cfg);
    }
}
