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
    
    
