package com.lyh.demo.controller;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
  @Autowired
  private RedisTemplate<String,Object> redisTemplate;
  @ResponseBody
  @RequestMapping({"/","/index"})
  public Object index(){
    return "你好 hello world -"+new Random().nextDouble();
  }

  @ResponseBody
  @RequestMapping("/testRedis")
  public Object testRedis(){
    redisTemplate.opsForValue().set("kevin","哈利波特 "+new Random().nextDouble());
    return redisTemplate.opsForValue().get("kevin");
  }


}
