package com.anhee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj05EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj05EurekaServerApplication.class, args);
	}

}
