# microservice-config-client-authenticating

> config client 有两种方式使用需要认证的 config server

- 使用curl风格的url
```
spring:
  cloud:
    config:
      uri: http://user:pass123@localhost:9999/ # 对应config server所获取的配置文件的{profile}
      profile: dev
      label: master # 对应config server所获取的配置文件的{label}

```
- 指定config server的用户名和密码