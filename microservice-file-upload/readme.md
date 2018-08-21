# microservice-file-upload

##上传文件服务需要考虑问题
  1. 可上传文件的大小
  2. 超时时间
##Zuul 的文件上传



对于小文件(1M以内)上传，无需任何处理，可以正常上传。
``` 
# zuul service upload success
curl -v -H "Transfer-Encoding: chunked" -F "file=small.txt" localhost:8040/microservice-file-upload/upload 
```
对于大文件(10M以上)上传，需要考虑配置可上传文件大小，以及超时时间
```
# 不添加 zuul 前缀 failed ： 超过默认可上传文件大小限制
curl -v -H "Transfer-Encoding: chunked" -F "file=large.txt" localhost:8040/microservice-file-upload/upload

# 添加 zuul 前缀 failed : 超时
curl -v -H "Transfer-Encoding: chunked" -F "file=large.txt" localhost:8040/zuul/microservice-file-upload/upload
```
- 更新 api-gateway application.yml 添加Hystrix容错超时时间，负载均衡超时时长


默认情况下，一个feign client是在hystrix断路器中执行，并利用ribbon进行软负载选择远程target service，所以可以想象出一个feign client的层次架构是包裹的层次，hystrix控制整个rpc从调用到方法返回，而ribbon控制从选址到socket返回，关于它们的超时设置，请参考我上一篇博客：SpringCloud重试机制配置


```
# execution.isolation.thread.timeoutInMilliseconds
# 设置调用者等待命令执行的超时限制，超过此时间，HystrixCommand被标记为TIMEOUT，并执行回退逻辑。
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds: 60000
ribbon:
  ConnectTimeout: 3000
  ReadTimeout: 60000
```

- stop gateway-zuul , start gateway-zuul-upload-file 
```
# zuul upload success
curl -v -H "Transfer-Encoding: chunked" -F "file=large.txt" localhost:8040/zuul/microservice-file-upload/upload
```

