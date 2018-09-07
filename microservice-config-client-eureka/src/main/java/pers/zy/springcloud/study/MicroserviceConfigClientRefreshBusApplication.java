package pers.zy.springcloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceConfigClientRefreshBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigClientRefreshBusApplication.class, args);
	}
}
