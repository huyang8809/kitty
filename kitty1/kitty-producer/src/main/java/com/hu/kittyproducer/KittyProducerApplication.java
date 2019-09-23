package com.hu.kittyproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KittyProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyProducerApplication.class, args);
	}

}
