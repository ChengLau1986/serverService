package com.lzapi.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * @author weilai <br/>
 * ==========================
 * Created with IDEA
 * Date: 2018/5/16
 * Time: 下午6:39
 * ==========================
 */
public class RedisCacheManager implements CacheManager {

    @Resource
    private RedisCache redisCache;


    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
