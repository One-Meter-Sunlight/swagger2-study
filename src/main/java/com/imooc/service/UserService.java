package com.imooc.service;

import com.imooc.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理 Service
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
public interface UserService {

    List<User> list();

    User selectEntity(Integer id);

    void deleteById(Integer id);
}
