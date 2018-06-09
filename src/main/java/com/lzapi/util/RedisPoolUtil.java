package com.lzapi.util;

import com.lzapi.common.RedisPool;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

import java.util.Set;

/**
 * Created by geely
 */
@Slf4j
public class RedisPoolUtil {

    public static String set(String key,String value){
        Jedis jedis = null;
        String result = null;

        try {
            jedis = RedisPool.getJedis();
            result = jedis.set(key,value);
        } catch (Exception e) {
            log.error("set key:{} value:{} error",key,value,e);
            RedisPool.returnBrokenResource(jedis);
            return result;
        }
        RedisPool.returnResource(jedis);
        return result;
    }

    //exTime的单位是秒
    public static String setEx(String key,String value,int exTime){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.setex(key,exTime,value);
        } catch (Exception e) {
            log.error("setex key:{} value:{} error",key,value,e);
            RedisPool.returnBrokenResource(jedis);
            return result;
        }
        RedisPool.returnResource(jedis);
        return result;
    }

    public static String get(String key){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            log.error("get key:{} error",key,e);
            RedisPool.returnBrokenResource(jedis);
            return result;
        }
        RedisPool.returnResource(jedis);
        return result;
    }

    /**
     * 设置key的有效期，单位是秒
     * @param key
     * @param exTime
     * @return
     */
    public static Long expire(String key,int exTime){
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.expire(key,exTime);
        } catch (Exception e) {
            log.error("expire key:{} error",key,e);
            RedisPool.returnBrokenResource(jedis);
            return result;
        }
        RedisPool.returnResource(jedis);
        return result;
    }

    public static Long del(String key){
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            log.error("del key:{} error",key,e);
            RedisPool.returnBrokenResource(jedis);
            return result;
        }
        RedisPool.returnResource(jedis);
        return result;
    }

    public static byte[] set(byte[] key, byte[] value) {
        try (Jedis jedis = RedisPool.getJedis()) {
            jedis.set(key, value);
            return value;
        }
    }

    public static void expire(byte[] key, int i) {
        try (Jedis jedis = RedisPool.getJedis()) {
            jedis.expire(key, i);
        }
    }

    public static byte[] get(byte[] key) {
        try (Jedis jedis = RedisPool.getJedis()) {
            return jedis.get(key);
        }
    }

    public static void del(byte[] key) {
        try (Jedis jedis = RedisPool.getJedis()) {
            jedis.del(key);
        }
    }

    public static Set<byte[]> keys(String shiro_session_prefix) {
        try (Jedis jedis = RedisPool.getJedis()) {
            return jedis.keys((shiro_session_prefix + "*").getBytes());
        }
    }


}
