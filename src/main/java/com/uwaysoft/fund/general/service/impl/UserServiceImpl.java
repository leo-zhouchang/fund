package com.uwaysoft.fund.general.service.impl;

import com.uwaysoft.fund.general.dao.UserDao;
import com.uwaysoft.fund.general.model.User;
import com.uwaysoft.fund.general.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhouchang on 2017/5/17.
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        userDao.save(user);
    }
}
