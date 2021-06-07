package com.feng.service;

import com.feng.model.User;

public interface UserService {
    User selectUserByUserName(String username,String password);
    boolean insertUser(User user);
    boolean delUser(User user);
}
