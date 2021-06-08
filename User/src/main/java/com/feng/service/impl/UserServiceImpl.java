package com.feng.service.impl;

import com.feng.dao.UserDao;
import com.feng.model.User;
import com.feng.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;


    @Override
    public int insert(User user) {
        return this.userDao.insert(user);
    }

    @Override
    public int insertSelective(User user) {
        return this.userDao.insertSelective(user);
    }

    @Override
    public int deleteByPrimarykey(Integer userid) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return this.userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return this.userDao.updateByPrimaryKey(user);
    }

    @Override
    public User selectByPrimaryKey(Integer userid) {
        return this.userDao.selectByPrimaryKey(userid);
    }

    @Override
    public int selectUseridByPhone(String phone) {
        try{
            return this.userDao.selectUseridByPhone(phone);
        }catch(Exception e){
            return 0;
        }
    }

    @Override
    public List<User> getAllForeach(List<Integer> list) {
        return this.userDao.getAllForeach(list);
    }
}
