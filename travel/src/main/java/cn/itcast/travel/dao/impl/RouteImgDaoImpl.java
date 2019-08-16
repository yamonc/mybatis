package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/7
 */
public class RouteImgDaoImpl  implements  RouteImgDao{
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<RouteImg> finByRid(int rid) {
        String sql=" select * from tab_route_img where rid=?";
        return template.query(sql,new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);

    }
}
