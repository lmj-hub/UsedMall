package com.feng.dao;

import com.feng.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User selectUserByUserName(@Param("username") String username);
    boolean insertUser(User user);
    boolean delUser(User user);
}
