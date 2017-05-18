package com.uwaysoft.fund.general.controller;

import com.uwaysoft.fund.general.model.User;
import com.uwaysoft.fund.general.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouchang on 2017/5/17.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user/list",
            method = RequestMethod.GET,
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String findAllUser(){
        return userService.findAll().toString();
    }

    @RequestMapping(value="/user/save")
    public void saveUser(){
        User user = new User();
        user.setName("小凳子");
        user.setPassword("1236");
        userService.saveUser(user);
    }
}
