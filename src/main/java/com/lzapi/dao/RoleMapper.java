package com.lzapi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lc on 2018/5/31.
 */
public interface RoleMapper {
    List<String> getRoles(@Param("account")String account);
}
