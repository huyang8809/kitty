package com.hu.kittyhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class KittyHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyHystrixApplication.class, args);
	}

}
