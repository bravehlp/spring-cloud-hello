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
### hello-register

### hello-service



### hello-client
服务消费者主要有两个目标：
1. 发现服务：Eureka客户端完成；
2. 消费服务：Ribbon完成。

#### 1、发现（获取）服务
服务消费者一启动，就会给服务注册中心发送一个REST请求来获取服务列表，此清单默认30秒更新一次，可通过配置文件改动此时间间隔。

#### 2、消费（调用）服务
服务消费者通过*服务名*获取服务的*实例名*和*实例的元数据*。Ribbon默认采用*轮训*的方式实现负载均衡的调用服务。
>一个Region包含多个Zone，一个Zone下可以有多个服务客户端和服务提供方。客户端优先调用同Zone下的服务，若访问不到再访问其他Zone下的服务。


#### 前置条件
1. 启动 hello-register
2. 启动 hello-service

### 源码分析

#### 服务提供者和服务消费者

注册服务到Eureka和从Eureka获取服务列表：
1、主类中配置@EnableDiscoveryClient；
2、application.properties中用*eureka.client.service-url.defaultZone*指定服务注册中心的位置。

