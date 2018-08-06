package pers.zy.springcloud.study.config.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "microservice-provider-user", configuration = CustomizingRibbonConfig.class)
public class EnableCustomizingRibbonConfig {
}
