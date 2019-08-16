package cn.itcast.travel.service;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/7
 */
public interface FavoriteService {
    /**
     * 判断是否收藏
     * @param rid
     * @param uid
     * @return
     */
    public boolean isFavorite(String rid,int uid);

    /**
     * 添加收藏
     *
     * @param rid
     * @param uid
     */
    void add(String rid, int uid);
}
