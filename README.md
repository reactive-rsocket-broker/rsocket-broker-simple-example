Alibaba RSocket Broker Example
==============================

一个最简单的RSocket Broker参考样例： requester向Broker发起调用，Broker将请求转发给Responder，最后将Responder的处理结果返回给requester。

# Maven模块列表

* service-api: User Service API
* user-service-spring-boot-starter: user-service对应的Spring Boot Starter
* rsocket-requester: RSocket服务消费端
* rsocket-responder: RSocket服务提供者

# 如何启动？

* 启动RSocket Broker: `docker-compose up -d`，RSocket Broker Web控制台为 http://localhost:9998/
* 启动服务提供方rsocket-responder: RSocketResponderServer.java
* 启动服务消费者 the rsocket-requester: RSocketRequesterApp.java
* 执行curl测试RSocket服务调用: `curl http://localhost:8181/user/1`

# 免费RSocket Broker

如果你觉得本地启动RSocket Broker还有些麻烦，你可以使用我们免费提供的在线Broker，  
你只需要将application.properties文件中的调整如下：

```
rsocket.brokers=tcp://139.196.223.16:9999,tcp://139.196.223.138:9999
```

然后执行一下 `curl https://jwt.alibroker.info` 获取对应的JWT token，然后设置为`rsocket.jwt-token`的属性值即可。

```
rsocket.jwt-token=xxx
```

这样你就可以连接到云上提供的免费RSocket Broker。 

# 参考资料

* Alibaba RSocket Broker: https://github.com/alibaba/alibaba-rsocket-broker
