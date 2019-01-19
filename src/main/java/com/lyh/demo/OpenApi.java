package com.lyh.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-boot-zookeeper-demo", path = "api")
public interface OpenApi {
  @RequestMapping(value = "/{name}/getUniqueId")
  public String getUniqueId(@PathVariable("name") String name);

  @RequestMapping(value = "/getValue")
  public String getValue(@RequestParam(value = "id") int id);
}
