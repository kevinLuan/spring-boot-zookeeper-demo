package com.lyh.demo.controller;

import com.lyh.demo.test.TestJdbc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDBController {
  @Autowired
  private TestJdbc testJdbc;

  @RequestMapping(value="/test/jdbc")
  public Object test(){
    return testJdbc.get();
  }
}
