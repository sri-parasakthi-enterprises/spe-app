package com.spe.speinvoiceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpeInvoiceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeInvoiceServiceApplication.class, args);
	}

}
