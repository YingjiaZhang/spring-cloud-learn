#相关参考
#遇到的坑
- **java.lang.IllegalArgumentException: URI is not absolute** 

    **原因**： @Value没有取到application.yml中userServiceUrl的值
    
    **解决**：`@Value("user.userServiceUrl) `改为 `@Value("${user.userServiceUrl}") `
