package com.feng.dao;

import com.feng.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User selectUserByUserName(@Param("username") String username,@Param("password") String password);
    boolean insertUser(User user);
    boolean delUser(User user);
}
