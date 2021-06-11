package com.feng.service;

import com.feng.dao.UserDao;
import com.feng.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public boolean addUser(User user) {
        return userDao.insert(user);
    }

    public User getUserByPhone(String phone) {
        User user  = userDao.getUserByPhone(phone);
        return  user;
    }

    public void updateUserName(User  user) {
        userDao.updateByPrimaryKey(user);
    }

    public User selectByPrimaryKey(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        return user;
    }


    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {}
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }


    @Override
    public User getUserById(int id) {

        return userDao.getUserById(id);
    }

    @Override
    public void deleteUserById(String ids) {
        this.userDao.deleteByPrimaryKey(Integer.parseInt(ids));

    }
    @Override
    public User selectUserByUserName(String username,String password) {
        return userDao.selectUserByUserName(username,password);
    }


}
