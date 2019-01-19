package com.lyh.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestFeignController{
  @Autowired
  OpenApi openApi;
  @RequestMapping(value="/test/feign")
  public Object test(){
    return openApi.getUniqueId("zhangsan");
  }
}
