# spring-cloud-hello



## 项目介绍

`spring-cloud-hello`是本人学习Spring Cloud的小例子，内容参考一本书《Spring Cloud微服务实战》，内容比较初级，大神勿喷。

## 组织结构

``` lua
spring-cloud-hello
├── hello-register -- 基于Eureka的微服务注册中心
├── hello-service -- 基于Eureka的微服务提供者
├── hello-client -- 基于Ribbon的微服务消费者
```

### hello-client
服务消费者主要有两个目标：
1. 发现服务：Eureka客户端完成；
2. 消费服务：Ribbon完成。

#### 前置条件
1. 启动 hello-register
2. 启动 hello-service

