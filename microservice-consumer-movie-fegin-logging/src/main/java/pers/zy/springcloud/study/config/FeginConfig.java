package pers.zy.springcloud.study.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeginConfig {

    @Bean
    Logger.Level feginLogger() {
        return Logger.Level.FULL;  // 记录请求及响应的body,header,元数据
//        return Logger.Level.NONE;  不记录任何日志
//        return Logger.Level.BASIC;  仅记录请求方法，URL，响应状态代码一级执行时间
//        return Logger.Level.HEADERS; 记录BASIC级别的基础上，记录请求和响应的header
    }
}
