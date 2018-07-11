package com.lchml.test.hikari;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.lchml.test.hikari.dao.UserDao;

@Service
public class UserService{

    @Resource
    private UserDao userDao;

    public int insertSelective(User pojo){
        return userDao.insertSelective(pojo);
    }

    public User get(long id) {
        return userDao.get(id);
    }
}
