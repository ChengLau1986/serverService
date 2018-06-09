package com.lzapi.service;

import com.lzapi.pojo.User;

import java.util.List;

/**
 * @author weilai <br/>
 * ==========================
 * Created with IDEA
 * Date: 2018/5/16
 * Time: 下午2:54
 * ==========================
 */
public interface UserService {
    User getUserByUsername(String username);
    List<String> queryRolesByUsername(String username);
}
