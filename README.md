#### spring-boot 集成zookeeper 作为注册中心

##### 启动入口类
    SystemApplication.main(String[]args)
  
##### 修改配置
  * redis 配置 (用来演示Redis调用)
  * mysql 配置 (目前没有演示使用到)
  
##### 调用REST API 访问
    #首页
    http://localhost:8081/index
    #测试redis
    http://localhost:8081/testRedis
    #演示feign api (使用zookeeper作为注册中心，所以启动该服务后，可以通过服务发现调用到目标(提供者)服务)
    http://localhost:8081/test/feign
    #如果想体验多台服务提供者自动发现及负载均衡的话，只需要启动多台实例即可，启动方式相同。
    
    
##### zookeeper注册中心配置
    #连接到Zookeeper集群的字符串(默认值:localhost:2181)
    spring.cloud.zookeeper.connectString=localhost:2181
    #激活zookeeper作为注册中心(默认:true)
    spring.cloud.zookeeper.enabled=true
  
    ----------服务提供者信息----------
    
    #provider in zookeeper 中的目录
    spring.cloud.zookeeper.discovery.root=/services
    #注册到注册中心(默认:true)
    spring.cloud.zookeeper.discovery.register=true
  
    #服务提供者注册在zookeeper中的目录结构如下:(默认方式，可修改)
    /services/${ServerName}/0384a048-bb1a-4b48-8819-2ceb7007b247
    实例:
      /services/spring-boot-zookeeper-demo/0384a048-bb1a-4b48-8819-2ceb7007b247
      

###### 注册实例信息
  ```json
  [
      {
          "serviceId":"spring-boot-zookeeper-demo",
          "host":"192.168.1.101",
          "port":8081,
          "secure":false,
          "uri":"http://192.168.1.101:8081",
          "metadata":{
  
          },
          "serviceInstance":{
              "name":"spring-boot-zookeeper-demo",
              "id":"36669ee4-9c17-4f99-9ef3-b7dfe6eca59d",
              "address":"192.168.1.101",
              "port":8081,
              "sslPort":null,
              "payload":{
                  "id":"application-1",
                  "name":"spring-boot-zookeeper-demo",
                  "metadata":{
  
                  }
              },
              "registrationTimeUTC":1547972060511,
              "serviceType":"DYNAMIC",
              "uriSpec":{
                  "parts":[
                      {
                          "value":"scheme",
                          "variable":true
                      },
                      {
                          "value":"://",
                          "variable":false
                      },
                      {
                          "value":"address",
                          "variable":true
                      },
                      {
                          "value":":",
                          "variable":false
                      },
                      {
                          "value":"port",
                          "variable":true
                      }
                  ]
              },
              "enabled":true
          },
          "scheme":null
      }
  ]
  
  ```

###### 开源项目源码 
    https://github.com/spring-cloud/spring-cloud-zookeeper
    #数据库官方配置手册
    http://shardingsphere.io/document/current/cn/manual/sharding-jdbc/configuration/config-spring-boot/
##### 问题反馈
    mailto: 136713318@qq.com