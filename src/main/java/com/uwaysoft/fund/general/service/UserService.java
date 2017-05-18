package com.uwaysoft.fund.general.service;

import com.uwaysoft.fund.general.model.User;

import java.util.List;

/**
 * Created by zhouchang on 2017/5/17.
 */
public interface UserService {
    public List<User> findAll();

    public void saveUser(User user);
}
