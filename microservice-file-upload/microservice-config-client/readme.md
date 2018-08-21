# microservice-config-client
```
server:
  port: 8081
spring:
  application:
    name: microservice-foo # 对应config server 所获取的配置文件中的 {application}
  cloud:
    config:
      uri: http://localhost:9999/ # config server的服务地址
      profile: dev # 对应 config server所获取的配置文件中的{profile}
      label: master # 指定config repo的git分支，对应config server 所获取的配置文件的{label}

```
### bootstrap.yml
以上属性需要配置在bootstrap.yml中，而不是application.yml中，如果配置在application.yml中，那么该部分配置并不会生效。
eg: config client 会链接spring.cloud.config.uri的默认值http://localhost:8888,而并不是链接 http://locahost:9999
### 引导上下文
引导上下文负责从配置服务器加载配置属性，以及解密外部配置中的属性。
和主应用程序加载application.*（yml/properties）中的属性不同， 引导上下文加载bootstrap.*中的属性。 配置在bootstrap.*中的属性有更高的优先级， 因此默认情况在它们不能够被本地配置覆盖
### 禁用引导过程
spring.cloud.bootstrap.enable=false

### Test
```
➜  spring-cloud-learn git:(master) curl http://localhost:8081/profile
dev-1.0%
```
