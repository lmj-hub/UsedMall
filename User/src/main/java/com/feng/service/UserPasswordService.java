package com.feng.service;

import com.feng.model.UserPassword;

public interface UserPasswordService {
    int insert(UserPassword record);

    int insertSelective(UserPassword record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPassword record);

    int updateByPrimaryKey(UserPassword record);

    UserPassword selectByPrimaryKey(Integer id);

    UserPassword selectByUid(Integer uid);
}
