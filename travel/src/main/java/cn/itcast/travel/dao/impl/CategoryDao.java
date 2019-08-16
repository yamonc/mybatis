package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/6
 */
public interface CategoryDao {
    /**
     * 查询所有
     *
     * @return
     */
    public List<Category> findAll();
}
