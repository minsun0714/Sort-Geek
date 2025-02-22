package com.demo.sortgeek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.demo.sortgeek.repository")
public class SortGeekApplication {

	public static void main(String[] args) {
		SpringApplication.run(SortGeekApplication.class, args);
	}

}
