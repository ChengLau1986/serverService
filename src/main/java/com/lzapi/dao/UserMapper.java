package com.lzapi.dao;

import com.lzapi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Map<String,Object> checkUser(@Param("account") String account, @Param("pwd") String pwd);

    User Login(@Param("account") String account, @Param("pwd") String pwd);

    String getPassword(@Param("account") String account);
}