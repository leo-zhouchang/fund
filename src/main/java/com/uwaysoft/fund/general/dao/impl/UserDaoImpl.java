package com.uwaysoft.fund.general.dao.impl;

import com.uwaysoft.fund.general.dao.UserDao;
import com.uwaysoft.fund.general.model.User;
import com.uwaysoft.fund.core.dao.impl.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouchang on 2017/5/17.
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoImpl implements UserDao {


    public List<User> findAll(){
        List<User> list = this.find("from User");
        return list;
    }

    @Override
    public void save(User user) {
        super.save(user);
    }
}
