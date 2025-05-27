package com.anhee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj07BillingMsProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj07BillingMsProviderApplication.class, args);
	}

}
