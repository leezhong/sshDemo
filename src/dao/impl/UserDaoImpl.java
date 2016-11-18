package dao.impl;

import dao.BaseDao;
import dao.Dao;
import dao.UserDao;
import entity.User;

import java.io.Serializable;

/**
 * Created by lz on 2016/11/18.
 */
public class UserDaoImpl extends Dao implements UserDao{

    @Override
    public User load(int userid) {
        return baseDao.load(userid,User.class);
    }

    @Override
    public User update(User user) {
        return baseDao.update(user);
    }

    @Override
    public int save(User user) {
        return (int)baseDao.create(user);
    }

    @Override
    public void remove(User user) {
        baseDao.remove(user);
    }
}
