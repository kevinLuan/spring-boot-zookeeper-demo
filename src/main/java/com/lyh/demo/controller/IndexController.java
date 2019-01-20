package com.lyh.demo.controller;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
  @Autowired
  private RedisTemplate<String,Object> redisTemplate;
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private Environment environment;
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

  /**
   * 获取服务名称
   * @return
   */
  @RequestMapping(value="/getServices")
  public List<String> getServices(){
    return discoveryClient.getServices();
  }

  /**
   * 获取注册实例列表
   * @return
   */
  @RequestMapping(value="/getInstance")
  public List<ServiceInstance> getInstance(){
    String sysName= environment.getProperty("spring.application.name");
    return discoveryClient.getInstances(sysName);
  }
}
