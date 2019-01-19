package com.lyh.demo;

import java.util.Random;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IncrementIdController implements  OpenApi{

  @RequestMapping(value = "/{name}/getUniqueId")
  public String getUniqueId(@PathVariable("name") String name) {
    System.out.println("变更---->>>>"+name);
    return "hello world->"+name;
  }

  @RequestMapping(value = "/getValue")
  public String getValue(@RequestParam(value = "id") int id) {
    return "ok";
  }
}
