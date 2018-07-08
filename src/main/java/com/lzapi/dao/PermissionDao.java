package com.lzapi.dao;

import com.lzapi.pojo.Permission;
import com.lzapi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lc on 2018/6/71.
 */
public interface PermissionDao {
    User getUserPermission(@Param("username") String username);
}
