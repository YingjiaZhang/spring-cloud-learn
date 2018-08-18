package pers.zy.springcloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulUploadFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulUploadFileApplication.class, args);
    }
}
