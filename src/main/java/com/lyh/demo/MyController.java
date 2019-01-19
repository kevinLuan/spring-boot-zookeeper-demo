package com.lyh.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
  @Autowired
  private RedisTemplate<String,Object> redisTemplate;

  @ResponseBody
  @RequestMapping("/testRedis")
  public Object testRedis(){
    redisTemplate.opsForValue().set("abc","哈利波特");
    return redisTemplate.opsForValue().get("abc");
  }

  @ResponseBody
  @RequestMapping({"/","/index"})
  public Object test(){
    return "你好 hello world";
  }
}
