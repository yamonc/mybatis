package com.itheima.dao.impl;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/20
 */

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 此类用于抽取dao的重复代码
 */
public class JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
