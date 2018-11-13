package com.example.vaadin_crypto_diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class VaadinCryptoDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaadinCryptoDiaryApplication.class, args);
	}
}
