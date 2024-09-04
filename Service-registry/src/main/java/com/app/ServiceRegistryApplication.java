package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Main application class for the Service Registry.
 * This application acts as a Eureka server for service discovery.
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication { 

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}

