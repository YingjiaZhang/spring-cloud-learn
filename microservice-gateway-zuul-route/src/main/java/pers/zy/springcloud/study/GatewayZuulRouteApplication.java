package pers.zy.springcloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

import java.util.regex.Pattern;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulRouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulRouteApplication.class, args);
	}

	@Bean
	public PatternServiceRouteMapper serviceRouteMapper(){
//public PatternServiceRouteMapper(String servicePattern, String routePattern);
//		servicePattern : 微服务名称正则
//		routePattern: 路由正则

		return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
// 该正则可将 xx-xxx-user-v1 映射到 v1/xx-xxx-user/** 路由
// curl http://localhost:8040/microservice-provider-user-v1/1
// {"timestamp":1534330602398,"status":404,"error":"Not Found","message":"No message available","path":"/microservice-provider-user-v1/1"}%                     curl http://localhost:8040/v1/microservice-provider-user/1
// {"id":1,"username":"account1","name":"张三","age":20,"balance":100.00}%
	}

}
