# microservice-config-client-refresh-cloud-bus
> 微服务a的所有实例都通过消息总线链接到了一起，每个实例斗气订阅配置更新事件。当其中一个微服务节点的/bus/refresh端点被请求时，该实例就会向消息总线发送一个配置更新的事件，其他实例获得该事件后也会更新配置。
- [Install RibbitMQ](https://blog.csdn.net/u010046908/article/details/54773323)
- [Install Kafka](https://blog.csdn.net/yu_meiguang/article/details/77685166)
- [Spring Cloud构建微服务架构（七）消息总线（续：Kafka）](https://www.jianshu.com/p/730d86030a41)

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
## 局部刷新
默认情况下 `Application Context ID` 是`spring.application.name:server.port`
- [解决Spring Cloud Bus不刷新所有节点的问题及理解"Application Context ID must be unique"](http://www.itmuch.com/spring-cloud-code-read/spring-cloud-code-read-spring-cloud-bus/)
