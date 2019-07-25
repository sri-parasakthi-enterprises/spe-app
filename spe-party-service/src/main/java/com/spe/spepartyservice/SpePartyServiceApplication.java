package com.spe.spepartyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpePartyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpePartyServiceApplication.class, args);
	}

}
