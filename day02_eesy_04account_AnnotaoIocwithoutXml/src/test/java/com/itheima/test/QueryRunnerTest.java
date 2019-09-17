package com.itheima.test;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/18
 */

import com.itheima.config.SpringConfig;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试QueryRunner是否单例
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfig.class);
        QueryRunner runner=ac.getBean("runner",QueryRunner.class);
        QueryRunner runner1=ac.getBean("runner",QueryRunner.class);
        System.out.println(runner==runner1);

    }
}
