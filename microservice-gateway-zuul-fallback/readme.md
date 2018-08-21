# microservice-gateway-zuul-fallback

Zuul 的 Hystrix 监控 的粒度是微服务，而不是某个API,同时也说明，所有经过Zuul的请求都会被Hystrix保护起来。 

当我们通过zuul访问一个微服务，若这个微服务不可用，则在浏览器中我们可以看到如下提示：
```
Whitelabel Erro Page

This application has no explicit for /error, so you are seeing this as a fallback
...
```
*那么,怎样为Zuul添加回退呢？*

想要为Zuul添加回退，需要实现ZuulFallbackProvider接口。
在实现类中，指定为那个微服务提供回退， 并提供一个ClientHttpResponse作为响应即可。


