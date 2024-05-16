package com.shanghai.jinan.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
@Slf4j
@Component
public class RedisService {
    private static Logger logger = LoggerFactory.getLogger(RedisService.class);

    public void setKeyValue(String key, String value) {
        try(Jedis jedis = JedisUtils.getJedis()) {
            jedis.set(key, value);
        } catch (Exception e) {
            logger.error("获取不到redis链接 {}",e.getMessage());
        }
    }

    public String getValueByKey(String key) {
        try(Jedis jedis = JedisUtils.getJedis()) {
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("获取不到redis链接 {}",e.getMessage());
        }
        return null;
    }
}
