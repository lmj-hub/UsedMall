package com.feng.service;

import com.feng.dao.UserDao;
import com.feng.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;
    @Override
    public User selectUserByUserName(String username) {
        return userDao.selectUserByUserName(username);
    }

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public boolean delUser(User user) {
        return userDao.delUser(user);
    }
}
