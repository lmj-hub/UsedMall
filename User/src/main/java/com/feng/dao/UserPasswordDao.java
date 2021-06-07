package com.feng.dao;

import com.feng.model.UserPassword;

public interface UserPasswordDao {
    int insert(UserPassword record);

    int insertSelective(UserPassword record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPassword record);

    int updateByPrimaryKey(UserPassword record);

    UserPassword selectByPrimaryKey(Integer id);

    UserPassword selectByUid(Integer uid);
}
