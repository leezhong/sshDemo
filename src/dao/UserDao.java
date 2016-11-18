package dao;

import entity.User;

/**
 * Created by lz on 2016/11/18.
 */
public interface UserDao {
    public User load(int userid);

    public User update(User user);

    public int save(User user);

    public void remove(User user);
}
