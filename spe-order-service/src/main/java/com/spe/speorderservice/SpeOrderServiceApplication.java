package com.spe.speorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpeOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeOrderServiceApplication.class, args);
	}

}
