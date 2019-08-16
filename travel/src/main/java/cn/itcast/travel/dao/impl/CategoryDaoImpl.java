package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/6
 */
public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql="select * from tab_category";
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }
}
