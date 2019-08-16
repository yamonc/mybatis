package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/7
 */
public interface RouteImgDao {
    /**
     * 根据route的id查询图片
     * @param rid
     * @return
     */
    public List<RouteImg> finByRid(int rid);
}
