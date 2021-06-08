package com.feng.service.impl;

import com.feng.dao.UserPasswordDao;
import com.feng.model.UserPassword;
import com.feng.service.UserPasswordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserPasswordServiceImpl")
public class UserPasswordServiceImpl implements UserPasswordService {
    @Resource
    private UserPasswordDao userPasswordDao;

    @Override
    public int insert(UserPassword record) {
        return userPasswordDao.insert(record);
    }

    @Override
    public int insertSelective(UserPassword record) {
        return userPasswordDao.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(UserPassword record) {
        return userPasswordDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserPassword record) {
        return userPasswordDao.updateByPrimaryKey(record);
    }

    @Override
    public UserPassword selectByPrimaryKey(Integer id) {
        return userPasswordDao.selectByPrimaryKey(id);
    }

    @Override
    public UserPassword selectByUid(Integer uid) {
        return userPasswordDao.selectByUid(uid);
    }
}
