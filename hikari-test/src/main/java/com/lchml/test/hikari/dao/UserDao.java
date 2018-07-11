package com.lchml.test.hikari.dao;

import com.lchml.test.hikari.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    int insertSelective(@Param("user") User user);

    User get(@Param("id") long id);
}
