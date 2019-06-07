package com.tarasenko.dockerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarasenko.dockerdemo.config.RedisConfig;

import redis.clients.jedis.Jedis;

@Service
public class RedisService
{

  private final RedisConfig redisConfig;
  private final Jedis jedis;

  @Autowired
  public RedisService(RedisConfig redisConfig)
  {
    this.redisConfig = redisConfig;
    this.jedis = new Jedis(redisConfig.getHost(), redisConfig.getPort());
  }

  public int incrementAndGetVisitsCount()
  {
    int visitsCount = readCurrentCount();
    visitsCount++;
    jedis.set(redisConfig.getRedisKey(), String.valueOf(visitsCount));

    return visitsCount;
  }

  private int readCurrentCount()
  {
    String visitsCount = jedis.get(redisConfig.getRedisKey());
    return visitsCount == null ? 0 : Integer.parseInt(visitsCount);
  }

}
