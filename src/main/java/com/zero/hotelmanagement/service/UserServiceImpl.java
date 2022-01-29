package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.dao.UserDao;
import com.zero.hotelmanagement.pojo.User;
import com.zero.hotelmanagement.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    //改为构造器注入
    @Autowired(required = false)
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int insertUser(User user) {
        user.setPwd(SHA.getResult(user.getPwd()));
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public int updateUser(User user) {
        user.setPwd(SHA.getResult(user.getPwd()));
        return userDao.updateUser(user);
    }

    @Override
    public List<User> selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public List<User> selectUserByName(String userName) {
        return userDao.selectUserByName(userName);
    }

    @Override
    public List<User> getUser(int page) {
        return userDao.getUser(6*(page-1));
    }

    @Override
    public int countAllUsers() {
        return userDao.countAllUsers();
    }
}
