package com.shanghai.jinan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void setKeyValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getValueByKey(String key) {
        if (key != null) {
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }
}
