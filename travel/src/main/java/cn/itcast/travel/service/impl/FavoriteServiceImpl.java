package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.impl.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

/**
 * Created by Intellij IDEA.
 * User:  陈亚萌
 * Date:  2019/8/7
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao=new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);

        return favorite!=null;//如果对象有值则为true
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }
}
