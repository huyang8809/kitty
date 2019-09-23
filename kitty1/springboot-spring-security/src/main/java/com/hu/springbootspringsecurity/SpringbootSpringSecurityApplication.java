package com.hu.springbootspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.hu.springbootspringsecurity")
@SpringBootApplication
public class SpringbootSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSpringSecurityApplication.class, args);
	}

}
