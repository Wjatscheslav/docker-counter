package com.tarasenko.dockerdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class RedisConfig
{

  @Value("${redis.host}")
  private String host;

  @Value("${redis.port}")
  private int port;

  @Value("${redis.key}")
  private String redisKey;

}
