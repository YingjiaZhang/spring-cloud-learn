package pers.zy.springcloud.study.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeginConfig {
    @Bean
    public Contract feginContract() {
        return new Contract.Default();
    }
}
