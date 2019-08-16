package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.impl.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/6
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao=new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //缓存优化1，从redis中查询
        //获取Jedis客户端
        Jedis jedis = JedisUtil.getJedis();
        //使用sortedSet
        //Set<String> categorys = jedis.zrange("category", 0, -1);

        //查询sortedset分数cid和值cname
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);


        List<Category> cs=null;
        //判断查询的集合是否为空
        if (categorys == null || categorys.size()==0) {
            System.out.println("从数据库读取");
            //如果为空，需要从数据库查询，再将数据存入redis
            //从数据库查询
            cs = categoryDao.findAll();
            //将数据存储到redis中的categor用的key
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category",cs.get(i).getCid(),cs.get(i).getCname());

            }
        }else {
            //如果不为空，将set数据存入list
            System.out.println("redis");
            cs=new ArrayList<Category>();
            for (Tuple tuple:categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                cs.add(category);
            }

        }
        return cs;

    }
}
