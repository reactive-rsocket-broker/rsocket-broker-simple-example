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

# 参考资料

* Alibaba RSocket Broker: https://github.com/alibaba/alibaba-rsocket-broker
