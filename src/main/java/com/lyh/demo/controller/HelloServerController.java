package com.lyh.demo.controller;

import com.lyh.demo.api.HelloApi;
import java.util.Random;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务端-API
 */
@RestController
@RequestMapping("/api/hello")
public class HelloServerController implements HelloApi {

  @RequestMapping(value = "/{name}/getUniqueId")
  public String getUniqueId(@PathVariable("name") String name) {
    System.out.println("SERVER--->>>>"+name);
    return "hello world->"+name+"  "+new Random().nextDouble();
  }

  @RequestMapping(value = "/getValue")
  public String getValue(@RequestParam(value = "id") int id) {
    return "ok:"+new Random().nextDouble();
  }
}
