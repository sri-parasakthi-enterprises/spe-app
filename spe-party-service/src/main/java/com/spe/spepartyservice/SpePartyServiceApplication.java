package com.spe.spepartyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpePartyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpePartyServiceApplication.class, args);
	}

}
