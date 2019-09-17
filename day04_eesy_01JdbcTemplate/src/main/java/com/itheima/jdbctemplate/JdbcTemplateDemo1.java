package com.itheima.jdbctemplate;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/19
 */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源spring内置数据源
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("root");
        //创建jdbcTemplate
        JdbcTemplate jt=new JdbcTemplate();
        //给jt设置数据源
        jt.setDataSource(ds);
        //执行
        jt.execute("insert into account(name,money) values('ccc',1000)");
        //
    }
}
