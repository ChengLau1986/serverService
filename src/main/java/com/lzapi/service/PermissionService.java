package com.lzapi.service;

import com.lzapi.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: hxy
 * @date: 2017/10/30 13:10
 */
public interface PermissionService {
    /**
     * 查询某用户的 角色  菜单列表   权限列表
     *
     * @param username
     * @return
     */
    User getUserPermission(String username);
}
