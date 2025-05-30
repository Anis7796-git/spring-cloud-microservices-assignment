package com.anhee.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj01EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj01EurekaServerApplication.class, args);
	}

}
