package com.duff.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The Class DuffBeerClientMicroserviceApplication.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DuffBeerClientMicroserviceApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DuffBeerClientMicroserviceApplication.class, args);
	}
}
