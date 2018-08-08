# microservice-consumer-movie-fegin-fallback

- 启动 microservice-dicovery-eureka
- 启动 microservice-provider-user
- 启动 microservice-consumer-movie-fegin-fallback
- 访问 `http://localhost:8010/user/1`可返回正常结果
```
➜  spring-cloud-learn git:(master) ✗ curl http://localhost:8010/user/1
{"id":1,"username":"account1","name":"张三","age":20,"balance":100.00}%

```
- 停止 microservice-provider-user
- 再次访问 `http://localhost:8010/user/1`

期待返回结果:

```
➜  spring-cloud-learn git:(master) ✗ curl http://localhost:8010/user/1
{"id":1,"username":"defalut user","name":null,"age":null,"balance":null}%
```
实际返回结果:
```
➜  spring-cloud-learn git:(master) ✗ curl http://localhost:8010/user/1
{"timestamp":1533713462898,"status":500,"error":"Internal Server Error","exception":"java.lang.RuntimeException","message":"com.netflix.client.ClientException: Load balancer does not have available server for client: microservice-provider-user","path":"/user/1"}%
```
原因:
```
Hystrix 不在项目的 classpath 中, Fegin无法用断路器包裹所有方法
```
解决:

通过 feign.hystrix.enabled: true 将 Hystrix 加入项目的 classpath 中,即在 application.yml 中加入如下配置即可
```
feign:
  hystrix:
    enabled: true
```

