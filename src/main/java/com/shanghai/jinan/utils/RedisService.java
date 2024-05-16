package com.shanghai.jinan.utils;

import org.springframework.stereotype.Component;

@Component
public class RedisService {

    public void setKeyValue(String key, String value) {
        JedisUtils.getJedis().set(key, value);
    }

    public String getValueByKey(String key) {
        if (key != null) {
            return JedisUtils.getJedis().get(key);
        }
        return null;
    }
}
