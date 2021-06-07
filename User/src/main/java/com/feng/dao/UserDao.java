package com.feng.dao;

import com.feng.model.User;

import java.util.List;

public interface UserDao {
    int insert(User user);

    int insertSelective(User user);

    int deleteByPrimarykey(Integer userid);//通过主键删除用户

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    User selectByPrimaryKey(Integer userid);//通过主键查询用户

    int selectUseridByPhone(String phone);//通过电话找到id

    List<User> getAllForeach(List<Integer> list);
}
