Alibaba RSocket Broker Example
==============================

# Maven模块列表

* service-api: User Service API
* user-service-spring-boot-starter: user-service对应的Spring Boot Starter
* rsocket-requester: RSocket服务消费端
* rsocket-responder: RSocket服务提供者

# 如何启动

* 启动RSocket Broker: `docker-compose up -d`，RSocket Broker Web控制台为 http://localhost:9998/
* 启动服务提供方rsocket-responder: RSocketResponderServer.java
* 启动服务消费者 the rsocket-requester: RSocketRequesterApp.java
* 执行curl测试RSocket服务调用: `curl http://localhost:8181/user/1`

# References

* Alibaba RSocket Broker: https://github.com/alibaba/alibaba-rsocket-broker
* RSocket Client CLI (RSC)： https://github.com/making/rsc
