package com.feng.service;

import com.feng.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public User getUserByPhone(String phone);

    public void updateUserName(User user);

    User selectByPrimaryKey(Integer id);

    public User getUserById(int id);

    public void deleteUserById(String idArr);

}
