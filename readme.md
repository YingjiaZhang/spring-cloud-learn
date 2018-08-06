# 参考

- [maven-dependency-scopes](http://www.baeldung.com/maven-dependency-scopes)

- [序列化与反序列化](https://www.jianshu.com/p/5a85011de960)

- [maven-wrapper](http://www.baeldung.com/maven-wrapper)

- [Spring Boot Actuator: management.security.enabled](https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/production-ready-monitoring.html)
- [package 命名规范](https://blog.csdn.net/kongjiea/article/details/45365753)

- [yml加载优先级](https://cloud.tencent.com/developer/article/1085852)
# 遇到的坑
- **java.lang.IllegalArgumentException: URI is not absolute** 

    **原因**： @Value没有取到application.yml中userServiceUrl的值
    
    **解决**：`@Value("user.userServiceUrl) `改为 `@Value("${user.userServiceUrl}") `

- **java.lang.IllegalArgumentException: URI is not absolute** 

    **原因**： @Value没有取到application.yml中userServiceUrl的值
    
    **解决**：`@Value("user.userServiceUrl) `改为 `@Value("${user.userServiceUrl}") `
    
- 若添加spring-cloud-starter依赖,在启动项目的时候不会初始化datasource schema 

- spring-cloud-version 不对导致项目启动报错 NoSuchMethodException : 更新版本为 Edgware.RELEASE

- 不能够导入jpa需要refresh maven源 



