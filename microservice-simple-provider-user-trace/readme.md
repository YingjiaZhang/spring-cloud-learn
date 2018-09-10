# microservice-simple-provider-user-trace

- no trace
```
Hibernate: select user0_.id as id1_0_0_, user0_.age as age2_0_0_, user0_.balance as balance3_0_0_, user0_.name as name4_0_0_, user0_.username as username5_0_0_ from user user0_ where user0_.id=?

```
- trace-plugin-1
```
# traceId:5d9a24f499d148ca
# spanId:5d9a24f499d148ca

2018-09-10 20:49:51.291 DEBUG [microservice-simple-provider-user-trace,5d9a24f499d148ca,5d9a24f499d148ca,false] 28910 --- [nio-8000-exec-2] o.s.web.servlet.DispatcherServlet        : DispatcherServlet with name 'dispatcherServlet' processing GET request for [/1]
2018-09-10 20:49:51.292 DEBUG [microservice-simple-provider-user-trace,5d9a24f499d148ca,5d9a24f499d148ca,false] 28910 --- [nio-8000-exec-2] o.s.web.servlet.DispatcherServlet        : Last-Modified value for [/1] is: -1
Hibernate: select user0_.id as id1_0_0_, user0_.age as age2_0_0_, user0_.balance as balance3_0_0_, user0_.name as name4_0_0_, user0_.username as username5_0_0_ from user user0_ where user0_.id=?
2018-09-10 20:49:51.295 DEBUG [microservice-simple-provider-user-trace,5d9a24f499d148ca,5d9a24f499d148ca,false] 28910 --- [nio-8000-exec-2] o.s.web.servlet.DispatcherServlet        : Null ModelAndView returned to DispatcherServlet with name 'dispatcherServlet': assuming HandlerAdapter completed request handling
2018-09-10 20:49:51.295 DEBUG [microservice-simple-provider-user-trace,5d9a24f499d148ca,5d9a24f499d148ca,false] 28910 --- [nio-8000-exec-2] o.s.web.servlet.DispatcherServlet        : Successfully completed request

```
- trace-plugin-2
```
2018-09-10 20:56:51.900 DEBUG [microservice-simple-provider-user-trace,,,] 29001 --- [nio-8000-exec-2] o.s.c.sleuth.instrument.web.TraceFilter  : Received a request to uri [/1] that should not be sampled [false]
2018-09-10 20:56:51.900 DEBUG [microservice-simple-provider-user-trace,a695644ce27051c5,a695644ce27051c5,false] 29001 --- [nio-8000-exec-2] o.s.c.sleuth.instrument.web.TraceFilter  : No parent span present - creating a new span
2018-09-10 20:56:51.902 DEBUG [microservice-simple-provider-user-trace,a695644ce27051c5,a695644ce27051c5,false] 29001 --- [nio-8000-exec-2] o.s.c.s.i.web.TraceHandlerInterceptor    : Handling span [Trace: a695644ce27051c5, Span: a695644ce27051c5, Parent: null, exportable:false]
2018-09-10 20:56:51.902 DEBUG [microservice-simple-provider-user-trace,a695644ce27051c5,a695644ce27051c5,false] 29001 --- [nio-8000-exec-2] o.s.c.s.i.web.TraceHandlerInterceptor    : Adding a method tag with value [findById] to a span [Trace: a695644ce27051c5, Span: a695644ce27051c5, Parent: null, exportable:false]
2018-09-10 20:56:51.902 DEBUG [microservice-simple-provider-user-trace,a695644ce27051c5,a695644ce27051c5,false] 29001 --- [nio-8000-exec-2] o.s.c.s.i.web.TraceHandlerInterceptor    : Adding a class tag with value [UserController] to a span [Trace: a695644ce27051c5, Span: a695644ce27051c5, Parent: null, exportable:false]
Hibernate: select user0_.id as id1_0_0_, user0_.age as age2_0_0_, user0_.balance as balance3_0_0_, user0_.name as name4_0_0_, user0_.username as username5_0_0_ from user user0_ where user0_.id=?
2018-09-10 20:56:51.905 DEBUG [microservice-simple-provider-user-trace,a695644ce27051c5,a695644ce27051c5,false] 29001 --- [nio-8000-exec-2] o.s.c.sleuth.instrument.web.TraceFilter  : Closing the span [Trace: a695644ce27051c5, Span: a695644ce27051c5, Parent: null, exportable:false] since the response was successful

```