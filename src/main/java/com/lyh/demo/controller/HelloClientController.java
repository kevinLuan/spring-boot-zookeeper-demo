package com.lyh.demo.controller;

import com.lyh.demo.api.HelloApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户端测试
 */
@RestController()
public class HelloClientController {
  @Autowired
  HelloApi helloApi;

  @RequestMapping(value="/test/feign")
  public Object test(){
    return helloApi.getUniqueId("zhangsan");
  }
}
