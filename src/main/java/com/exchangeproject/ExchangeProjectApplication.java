package com.exchangeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
public class ExchangeProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExchangeProjectApplication.class, args);
	}	
}

