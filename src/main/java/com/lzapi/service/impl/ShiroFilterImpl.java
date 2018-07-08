package com.lzapi.service.impl;

import com.lzapi.dao.ShiroFilterDao;
import com.lzapi.pojo.ShiroFilter;
import com.lzapi.service.ShiroFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lc on 2018/7/2.
 */
@Service
public class ShiroFilterImpl implements ShiroFilterService {
    @Autowired
    private ShiroFilterDao shiroFilterDao;

    @Override
    public List<ShiroFilter> getShiroFilter() {
        return shiroFilterDao.getShiroFilter();
    }
}
