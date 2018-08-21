# microservice-config-client

```
server:
  port: 8081
spring:
  application:
    name: microservice-foo # 对应config server所获取的配置文件的{application}
  cloud:
    config:
      uri: http://localhost:9999/ # 对应config server所获取的配置文件的{profile}
      profile: dev
      label: master # 对应config server所获取的配置文件的{label}
```

### bootstrap.yml
以上配置内容需要配置在bootstrap.yml中，而不是application.yml中。
如果配置在application.yml中，Config server 就会在链接spring.cloud.config.uri的默认值http://localhost:8888/，而不是配置文件中的http://localhost:9999/

### 引导上下文
引导上下文负责从配置服务器加载配置属性，以及解密歪脖配置文件中的属性。
和主应用程序加载application.*中的属性不同，引导上下文加载bootstrap.*中的属性。配置在bootstrap.yml中的属性具有更高的有限级，因此默认情况下不能够被本地配置所覆盖

### 禁用引导过程
spring.cloud.bootstrap.enable=false;

### Test
```
curl http://localhost:8081/profile
dev-10%
```