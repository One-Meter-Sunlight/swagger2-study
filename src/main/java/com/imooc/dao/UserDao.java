package com.imooc.dao;

import com.imooc.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户管理 Dao
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
public interface UserDao{

    List<User> list();

    User selectEntity(Integer id);

    void deleteById(Integer id);
}
