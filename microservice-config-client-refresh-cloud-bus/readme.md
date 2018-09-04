# microservice-config-client-refresh-cloud-bus
> 微服务a的所有实例都通过消息总线链接到了一起，每个实例斗气订阅配置更新事件。当其中一个微服务节点的/bus/refresh端点被请求时，该实例就会向消息总线发送一个配置更新的事件，其他实例获得该事件后也会更新配置。
- [Install RibbitMQ](https://blog.csdn.net/u010046908/article/details/54773323)
- [Install Kafka](https://blog.csdn.net/yu_meiguang/article/details/77685166)
- [Spring Cloud构建微服务架构（七）消息总线（续：Kafka）](https://www.jianshu.com/p/730d86030a41)
## Use rabbitmq
```
brew install rabbitmq 
brew services start rabbitmq
cd /usr/local/Cellar/rabbitmq/3.7.7_1/sbin
sudo ./rabbitmq-plugins enable rabbitmq_management  # RabbitMQ 启动插件
浏览器输入：http://localhost:15672/ 
账号密码初始默认都为guest
```
## 自动刷新
- start config server
- start config client refresh cloud bus
```
22:48:54.437  INFO 75592 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/bus/refresh],methods=[POST]}" onto public void org.springframework.cloud.bus.endpoint.RefreshBusEndpoint.refresh(java.lang.String)
```
- update client server port and start 
- test current plugin
```
➜  microservice-config-client-refresh-cloud-bus git:(master) ✗ curl http://localhost:8081/profile
dev-0.1-change-2%                                                               ➜  microservice-config-client-refresh-cloud-bus git:(master) ✗ curl http://localhost:8082/profile
dev-0.1-change-2%
```
- update config repo 
```
➜  spring-cloud-config-repo git:(master) echo 'profile=dev-1.0-bus' > microservice-foo-dev.properties
➜  spring-cloud-config-repo git:(master) ✗ git add .
➜  spring-cloud-config-repo git:(master) ✗ gc -m "change profile about microservice-foo-dev.properties for bus"
➜  spring-cloud-config-repo git:(master) git push
```
- refresh
```
➜  spring-cloud-config-repo git:(master) curl -X POST http://localhost:8081/bus/refresh
```
- check 
```
➜  spring-cloud-config-repo git:(master) curl http://localhost:8081/profile
dev-1.0-bus%                                                                    ➜  spring-cloud-config-repo git:(master) curl http://localhost:8082/profile
dev-1.0-bus%
```
- git repo配置WebHooks：当代码库有新的提交时，可配置一个自动发送的refresh请求，实现自动刷新
## 局部刷新
> 某些场景下,只想要刷新部分服务的配置，可以同个/bus/refresh端点的destination参数来定位要刷新的应用程序
eg:
```
curl http://{host}:{port}/bus/refresh?destination=customers:9000 
这样消息总线上的微服务实例可以根据destionation参数值来判断是否需要刷新。customer:9000指的是各个微服务的AppliactionContextID
```
默认情况下 `Application Context ID` 是`spring.application.name:server.port`
- [解决Spring Cloud Bus不刷新所有节点的问题及理解"Application Context ID must be unique"](http://www.itmuch.com/spring-cloud-code-read/spring-cloud-code-read-spring-cloud-bus/)


## 架构改进
### Why？
上述架构通过请求某个微服务的 `/bus/refresh`端点的方式来实现配置刷新，但是这种方法并不是很好：
- 破坏了单一职责原则：业务微服务应该只关心业务，不应该承担配置刷新的职责
- 破坏了微服务节点的对称性？
- 有一定局限性：当微服务在迁移的时候，网络地址发生变化，可能需要更新WebHooks配置
### How?
将config server也加入到消息总线中，并使用config server的`/bus/refresh`端点来实现配置的刷新。
