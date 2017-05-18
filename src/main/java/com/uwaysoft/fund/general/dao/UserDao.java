package com.uwaysoft.fund.general.dao;

import com.uwaysoft.fund.general.model.User;

import java.util.List;

/**
 * Created by zhouchang on 2017/5/17.
 */
public interface UserDao {
    public List<User> findAll();

    public void save(User user);
}
