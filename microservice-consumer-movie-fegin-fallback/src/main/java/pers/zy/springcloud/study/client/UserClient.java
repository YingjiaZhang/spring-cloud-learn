package pers.zy.springcloud.study.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pers.zy.springcloud.study.dto.User;

@FeignClient(name = "microservice-provider-user",fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("/{id}")
    User findById(@PathVariable("id") Long id);
}
