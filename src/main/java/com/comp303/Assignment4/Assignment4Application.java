package com.comp303.Assignment4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableEurekaServer
@SpringBootApplication
@EnableMongoRepositories
public class Assignment4Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment4Application.class, args);
	}

}
