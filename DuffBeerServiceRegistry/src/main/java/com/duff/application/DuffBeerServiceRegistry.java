package com.duff.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DuffBeerServiceRegistry {

	public static void main(String[] args) {
		SpringApplication.run(DuffBeerServiceRegistry.class, args);
	}
}
