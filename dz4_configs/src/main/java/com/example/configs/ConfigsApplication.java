package com.example.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ConfigsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigsApplication.class, args);
	}
}
