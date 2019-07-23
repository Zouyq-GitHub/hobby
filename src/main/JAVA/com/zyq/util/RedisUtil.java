package com.zyq.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 用来连接redis数据库的Util
 */

public class RedisUtil {
    //静态激活连接池
    private static JedisPool jedisPool=new JedisPool();

    //提供调用者方法，获取资源返回
    public static Jedis getConnection(){
        return  jedisPool.getResource();
    }

}
