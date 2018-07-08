package com.lzapi.common;

/**
 * Created by lc on 2018/3/29.
 */
public class Const {
    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String TOKEN_PREFIX = "token_";
    public static final String TOKEN_NAME = "login_token";

    public static final String SHIRO_SESSION_PREFIX="login_session";
    public static final String SHIRO_CACH_PREFIX = "login_cache";
    public static final String USER_INFO="user_info";

    public interface RedisCacheExtime{
        int REDIS_SESSION_EXTIME = 60 * 30;//30分钟
    }
}
