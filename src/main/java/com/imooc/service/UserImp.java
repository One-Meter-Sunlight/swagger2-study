package com.imooc.service;

import com.imooc.dao.UserDao;
import com.imooc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理 ServiceImp
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
@Service
public class UserImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public User selectEntity(Integer id) {
        return userDao.selectEntity(id);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }
}
