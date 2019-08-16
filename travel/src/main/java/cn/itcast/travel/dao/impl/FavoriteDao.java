package cn.itcast.travel.dao.impl;

import cn.itcast.travel.domain.Favorite;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/7
 */
public interface FavoriteDao {
    /**
     * 根据rid和 uid查询收藏等信息
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findByRidAndUid(int rid, int uid);

    /**
     * 根据rid查询收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    /**
     * 添加收藏
     * @param parseInt
     * @param uid
     */
    void add(int parseInt, int uid);
}
