package com.spe.speconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpeConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeConfigServiceApplication.class, args);
	}

}
