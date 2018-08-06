package pers.zy.springcloud.study.client;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import pers.zy.springcloud.study.config.FeginConfig;
import pers.zy.springcloud.study.dto.User;

@FeignClient(name = "microservice-provider-user", configuration = FeginConfig.class)
public interface UserClient {

    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
