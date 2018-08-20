# microservice-gateway-zuul-filter
[Zuul filter 详解](https://www.jianshu.com/p/fcc0be4ec285)

```
curl http://localhost:8040/microservice-provider-user/1
{"id":1,"username":"account1","name":"张三","age":20,"balance":100.00}%
```

```

2018-08-20 10:32:21.610  INFO 4479 --- [nio-8040-exec-2] p.z.s.study.filter.PreRequestLogFilter   : send GET request to http://localhost:8040/microservice-provider-user/1
```