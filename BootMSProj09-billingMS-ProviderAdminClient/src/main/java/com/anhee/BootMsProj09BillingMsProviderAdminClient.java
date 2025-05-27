package com.anhee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj09BillingMsProviderAdminClient {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj09BillingMsProviderAdminClient.class, args);
	}

}
