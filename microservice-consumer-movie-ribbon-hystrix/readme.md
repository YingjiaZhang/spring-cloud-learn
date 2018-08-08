# microservice-consumer-movie-ribbon-hystrix

##Hystrix 线程隔离策略 : execution.isolation.strategy


- THREAD (线程隔离) : 使用该方式, HystrixCommand将会在单独的线程上执行, 并发请求受线程池中的线程数量的限制

- SEMAPHORE (信号量隔离) : 使用该方式, HystrixCommand将会在调用的线程中执行,开销较小,并发请求受到信号量个数的限制


##适用情况  
> Hystrix 默认并且推荐使用线程隔离(THREAD),因为这种方式有一个除网络超时以外的额外保护层。
一般情来说, 只有当调用负载非常高时间(例如每个实例每秒调用数百次),才需要使用信号量隔离,因为这种场景下使用THREAD开销会比较高。信号量隔离一般仅适用于非网络调用的隔离。 

- Hystrix 的隔离策略有 THREAD 和 SEMAPHORE 两种,默认是 THREAD
- 正常情况下,保持默认即可
- 如果发生找不到上下文的运行时异常,可考虑将隔离策略设置成 SEMAPHORE 




