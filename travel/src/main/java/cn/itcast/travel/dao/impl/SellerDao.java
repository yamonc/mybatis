package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.Seller;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/7
 */
public interface SellerDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Seller findById(int id);
}
