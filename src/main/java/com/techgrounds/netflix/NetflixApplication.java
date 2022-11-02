package com.techgrounds.netflix;

import com.techgrounds.netflix.controller.userController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NetflixApplication {
	public static void main(String[] args) {
		SpringApplication.run(NetflixApplication.class, args);
	}
}
