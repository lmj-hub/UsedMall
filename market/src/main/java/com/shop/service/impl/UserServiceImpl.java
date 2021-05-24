package com.shop.service.impl;

import com.shop.base.BaseDao;
import com.shop.base.BaseServiceImpl;
import com.shop.mapper.UserMapper;
import com.shop.po.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseDao<User> getBaseDao(){
        return userMapper;
    }
}
