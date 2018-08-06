package pers.zy.springcloud.study.config.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomizingRibbonConfig {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
