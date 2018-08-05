package pers.zy.springcloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderUserMyMetadataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUserMyMetadataApplication.class, args);
	}
}


