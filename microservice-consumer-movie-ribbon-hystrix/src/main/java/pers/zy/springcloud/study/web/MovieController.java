package pers.zy.springcloud.study.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pers.zy.springcloud.study.dto.User;

@Slf4j
@RestController
public class MovieController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     *  execution.isolation.thread.timeoutInMilliseconds 执行隔离的超时时间 : 默认1000ms
     *  metrics.rollingStats.timeInMilliseconds 设置滑动窗口的统计时间,熔断器使用这个时间 : 默认10s
     *  coreSize 设置线程池的大小,这是最大的并发执行数量 : 默认10
     *  maxQueueSize 最大队列长度,设置BlockingQueue的最大长度 : 默认-1。
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
    }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "10")
    })
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }

    public User findByIdFallback(Long id) {
        return User.builder().id(-1L).name("default user").build();
    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        log.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }


}
