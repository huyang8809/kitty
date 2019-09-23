package com.hu.kittyzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class KittyZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyZuulApplication.class, args);
	}

}
