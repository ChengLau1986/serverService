package com.lzapi.service.impl;

import com.lzapi.dao.PermissionDao;
import com.lzapi.pojo.User;
import com.lzapi.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lc on 2018/6/7.
 */
@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public User getUserPermission(String username) {
        User userPermission = permissionDao.getUserPermission(username);
        return userPermission;
    }

}
