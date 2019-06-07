package com.tarasenko.dockerdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarasenko.dockerdemo.service.RedisService;

@Controller
@RequestMapping("/visit")
public class VisitsCountController
{

  private final RedisService redisService;

  @Autowired
  public VisitsCountController(RedisService redisService)
  {
    this.redisService = redisService;
  }

  @GetMapping(value = "/count", produces = "application/json")
  public @ResponseBody String getVisitsCount() {
    return String.valueOf(redisService.incrementAndGetVisitsCount());
  }

}
