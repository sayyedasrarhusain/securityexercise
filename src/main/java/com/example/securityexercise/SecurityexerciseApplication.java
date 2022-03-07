package com.example.securityexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SecurityexerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityexerciseApplication.class, args);
	}

}
