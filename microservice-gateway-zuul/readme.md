# microservice-gateway-zuul

 默认情况下，Zuul会代理所有注册到Eureka上的微服务，并且Zuul的路由规则如下 http://ZUUL_HOST:ZUUL_PROT/微服务在Eureka上的serviceId/** 会被转发到serviceId对应的微服务