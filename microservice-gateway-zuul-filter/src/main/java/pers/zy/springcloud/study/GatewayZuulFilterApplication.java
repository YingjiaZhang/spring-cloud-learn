package pers.zy.springcloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import pers.zy.springcloud.study.filter.PreRequestLogFilter;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulFilterApplication {

    @Bean
    public PreRequestLogFilter preRequestLogFilter() {
        return new PreRequestLogFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulFilterApplication.class, args);
    }
}
