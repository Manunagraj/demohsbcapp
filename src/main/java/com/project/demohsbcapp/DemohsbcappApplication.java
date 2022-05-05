package com.project.demohsbcapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemohsbcappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemohsbcappApplication.class, args);
	}

}
