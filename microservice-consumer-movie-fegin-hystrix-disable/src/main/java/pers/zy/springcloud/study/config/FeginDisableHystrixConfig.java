package pers.zy.springcloud.study.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeginDisableHystrixConfig {

    @Bean
    @Scope("prototype")
    public Feign.Builder feginBuilder(){
        return Feign.builder();

    }
}
