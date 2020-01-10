package com.restbuku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrudRestbukuApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestbukuApplication.class, args);
	}

}
