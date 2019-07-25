package com.spe.speproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpeProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeProductServiceApplication.class, args);
	}

}
