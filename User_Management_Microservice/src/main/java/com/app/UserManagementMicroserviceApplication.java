package com.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User Management Microservice API", version = "1.0", description = "API for managing user profiles and authentication in the Online Salon Service", contact = @Contact(name = "Gousiya Begam", email = "gousiyabegamsk786@gmail.com")))
public class UserManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementMicroserviceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
