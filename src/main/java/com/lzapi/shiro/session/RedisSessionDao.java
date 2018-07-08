package com.lzapi.shiro.session;

import com.lzapi.common.Const;
import com.lzapi.util.RedisPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author weilai <br/>
 * ==========================
 * Created with IDEA
 * Date: 2018/5/16
 * Time: 下午3:58
 * ==========================
 */
@Slf4j
public class RedisSessionDao extends AbstractSessionDAO {

    private byte[] getKey(String key) {
        return (Const.SHIRO_SESSION_PREFIX + key).getBytes();
    }

    private void saveSession(Session session) {
        if (session != null && session.getId() != null) {
            byte[] key = getKey(session.getId().toString());
            byte[] value = SerializationUtils.serialize(session);
            RedisPoolUtil.set(key, value);
            RedisPoolUtil.expire(key, Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        log.debug("从redis中读取 session数据");
        if (sessionId == null) {
            return null;
        }
        byte[] key = getKey(sessionId.toString());
        byte[] value = RedisPoolUtil.get(key);
        return (Session) SerializationUtils.deserialize(value);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            return;
        }
        byte[] key = getKey(session.getId().toString());
        RedisPoolUtil.del(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<byte[]> keys = RedisPoolUtil.keys(Const.SHIRO_SESSION_PREFIX);
        Set<Session> sessions = new HashSet<>();
        if (CollectionUtils.isEmpty(keys)) {
            return sessions;
        }
        for (byte[] key : keys) {
            Session session = (Session) SerializationUtils.deserialize(key);
            sessions.add(session);
        }
        return sessions;
    }
}
