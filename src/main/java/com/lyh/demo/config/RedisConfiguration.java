package com.lyh.demo.config;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("redis.cache")
public class RedisConfiguration {
  private String host;
  private String password;
  private int port;
  private int timeout;


  //测试Map配置
  @NestedConfigurationProperty
  private Map<String, Bean> user = Maps.newHashMap();
  @Data
  public static class Bean{
    int id;
    String name;
  }
}
