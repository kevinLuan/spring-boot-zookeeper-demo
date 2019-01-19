package com.lyh.demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-boot-zookeeper-demo", path = "api/hello")
public interface HelloApi {

  @RequestMapping(value = "/{name}/getUniqueId")
  public String getUniqueId(@PathVariable("name") String name);

  @RequestMapping(value = "/getValue")
  public String getValue(@RequestParam(value = "id") int id);
}
