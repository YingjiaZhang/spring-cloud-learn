# microservice-simple-consumer-movie-trace

- trace-plugin-2

```
2018-09-10 21:07:01.035 DEBUG [microservice-simple-consumer-movie-trace,,,] 29199 --- [nio-8010-exec-2] o.s.c.sleuth.instrument.web.TraceFilter  : Received a request to uri [/user/1] that should not be sampled [false]
2018-09-10 21:07:01.035 DEBUG [microservice-simple-consumer-movie-trace,7678079b9c2b4775,7678079b9c2b4775,false] 29199 --- [nio-8010-exec-2] o.s.c.sleuth.instrument.web.TraceFilter  : No parent span present - creating a new span
2018-09-10 21:07:01.038 DEBUG [microservice-simple-consumer-movie-trace,7678079b9c2b4775,7678079b9c2b4775,false] 29199 --- [nio-8010-exec-2] o.s.c.s.i.web.TraceHandlerInterceptor    : Handling span [Trace: 7678079b9c2b4775, Span: 7678079b9c2b4775, Parent: null, exportable:false]
2018-09-10 21:07:01.038 DEBUG [microservice-simple-consumer-movie-trace,7678079b9c2b4775,7678079b9c2b4775,false] 29199 --- [nio-8010-exec-2] o.s.c.s.i.web.TraceHandlerInterceptor    : Adding a method tag with value [findById] to a span [Trace: 7678079b9c2b4775, Span: 7678079b9c2b4775, Parent: null, exportable:false]
2018-09-10 21:07:01.038 DEBUG [microservice-simple-consumer-movie-trace,7678079b9c2b4775,7678079b9c2b4775,false] 29199 --- [nio-8010-exec-2] o.s.c.s.i.web.TraceHandlerInterceptor    : Adding a class tag with value [MovieController] to a span [Trace: 7678079b9c2b4775, Span: 7678079b9c2b4775, Parent: null, exportable:false]
2018-09-10 21:07:01.038 DEBUG [microservice-simple-consumer-movie-trace,7678079b9c2b4775,7776688a1319f5b8,false] 29199 --- [nio-8010-exec-2] .w.c.AbstractTraceHttpRequestInterceptor : Starting new client span [[Trace: 7678079b9c2b4775, Span: 7776688a1319f5b8, Parent: 7678079b9c2b4775, exportable:false]]
2018-09-10 21:07:01.050 DEBUG [microservice-simple-consumer-movie-trace,7678079b9c2b4775,7678079b9c2b4775,false] 29199 --- [nio-8010-exec-2] o.s.c.sleuth.instrument.web.TraceFilter  : Closing the span [Trace: 7678079b9c2b4775, Span: 7678079b9c2b4775, Parent: null, exportable:false] since the response was successful

```

```
2018-09-10 21:07:01.042 DEBUG [microservice-simple-provider-user-trace,,,] 29211 --- [nio-8000-exec-3] o.s.c.sleuth.instrument.web.TraceFilter  : Received a request to uri [/1] that should not be sampled [true]
2018-09-10 21:07:01.042 DEBUG [microservice-simple-provider-user-trace,,,] 29211 --- [nio-8000-exec-3] o.s.c.sleuth.instrument.web.TraceFilter  : Found a parent span [Trace: 7678079b9c2b4775, Span: 7776688a1319f5b8, Parent: 7678079b9c2b4775, exportable:false] in the request
2018-09-10 21:07:01.042 DEBUG [microservice-simple-provider-user-trace,7678079b9c2b4775,7776688a1319f5b8,false] 29211 --- [nio-8000-exec-3] o.s.c.sleuth.instrument.web.TraceFilter  : Parent span is [Trace: 7678079b9c2b4775, Span: 7776688a1319f5b8, Parent: 7678079b9c2b4775, exportable:false]
2018-09-10 21:07:01.045 DEBUG [microservice-simple-provider-user-trace,7678079b9c2b4775,7776688a1319f5b8,false] 29211 --- [nio-8000-exec-3] o.s.c.s.i.web.TraceHandlerInterceptor    : Handling span [Trace: 7678079b9c2b4775, Span: 7776688a1319f5b8, Parent: 7678079b9c2b4775, exportable:false]
2018-09-10 21:07:01.045 DEBUG [microservice-simple-provider-user-trace,7678079b9c2b4775,7776688a1319f5b8,false] 29211 --- [nio-8000-exec-3] o.s.c.s.i.web.TraceHandlerInterceptor    : Adding a method tag with value [findById] to a span [Trace: 7678079b9c2b4775, Span: 7776688a1319f5b8, Parent: 7678079b9c2b4775, exportable:false]
2018-09-10 21:07:01.045 DEBUG [microservice-simple-provider-user-trace,7678079b9c2b4775,7776688a1319f5b8,false] 29211 --- [nio-8000-exec-3] o.s.c.s.i.web.TraceHandlerInterceptor    : Adding a class tag with value [UserController] to a span [Trace: 7678079b9c2b4775, Span: 7776688a1319f5b8, Parent: 7678079b9c2b4775, exportable:false]
Hibernate: select user0_.id as id1_0_0_, user0_.age as age2_0_0_, user0_.balance as balance3_0_0_, user0_.name as name4_0_0_, user0_.username as username5_0_0_ from user user0_ where user0_.id=?
2018-09-10 21:07:01.048 DEBUG [microservice-simple-provider-user-trace,7678079b9c2b4775,7776688a1319f5b8,false] 29211 --- [nio-8000-exec-3] o.s.c.sleuth.instrument.web.TraceFilter  : Trying to send the parent span [Trace: 7678079b9c2b4775, Span: 7776688a1319f5b8, Parent: 7678079b9c2b4775, exportable:false] to Zipkin
2018-09-10 21:07:01.048 DEBUG [microservice-simple-provider-user-trace,7678079b9c2b4775,7776688a1319f5b8,false] 29211 --- [nio-8000-exec-3] o.s.c.sleuth.instrument.web.TraceFilter  : Closing the span [Trace: 7678079b9c2b4775, Span: 7776688a1319f5b8, Parent: 7678079b9c2b4775, exportable:false] since the response was successful

```