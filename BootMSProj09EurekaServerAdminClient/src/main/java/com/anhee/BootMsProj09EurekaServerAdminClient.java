package com.anhee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj09EurekaServerAdminClient {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj09EurekaServerAdminClient.class, args);
	}

}
