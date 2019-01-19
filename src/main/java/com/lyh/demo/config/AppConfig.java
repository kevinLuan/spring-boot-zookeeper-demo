package com.lyh.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class AppConfig {
  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
    connectionFactory.setHostName("127.0.0.1");
    connectionFactory.setPort(6379);
    connectionFactory.setPassword("123456");
    connectionFactory.setTimeout(1000);
    return connectionFactory;
  }
  @Bean
  @Autowired
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    template.setConnectionFactory(factory);
    template.setKeySerializer(new StringRedisSerializer());
    return template;
  }
}
