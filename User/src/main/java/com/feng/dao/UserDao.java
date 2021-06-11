package com.feng.dao;

import com.feng.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    boolean insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByPhone(String phone);//通过手机号查询用户

    public List<User> getUserList();//获取所有用户

    User getUserById(int id);

    User selectUserByUserName(@Param("username") String username,@Param("password") String password);

    List<User> getUserListByUser(@Param("phone") String phone,@Param("username") String username,@Param("sno") String sno);

}
