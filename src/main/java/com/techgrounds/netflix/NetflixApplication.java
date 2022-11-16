package com.techgrounds.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
public class NetflixApplication {
	public static void main(String[] args) {
		SpringApplication.run(NetflixApplication.class, args);
	}
}
