package com.lzapi.shiro.cache;

import com.lzapi.common.Const;
import com.lzapi.util.RedisPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.util.Collection;
import java.util.Set;

/**
 * @author weilai <br/>
 * ==========================
 * Created with IDEA
 * Date: 2018/5/16
 * Time: 下午6:39
 * ==========================
 */
@Slf4j
@Component
public class RedisCache<K, V> implements Cache<K, V> {

    private byte[] getKey(K k) {
        if (k instanceof String) {
            return (Const.SHIRO_CACH_PREFIX + k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }

    @Override
    public V get(K k) throws CacheException {
        log.debug("从 redis 中获取权限数据");
        byte[] value = RedisPoolUtil.get(getKey(k));
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = SerializationUtils.serialize(v);
        RedisPoolUtil.set(key, value);
        RedisPoolUtil.expire(key, Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = RedisPoolUtil.get(key);
        RedisPoolUtil.del(key);
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
