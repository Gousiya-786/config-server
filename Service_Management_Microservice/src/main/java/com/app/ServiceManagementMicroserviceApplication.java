package com.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Services Management MicroService", description = "Comprehensive documentation for the Spring Boot REST API", version = "v1.0", contact = @Contact(name = "Gousiya Begam", email = "gousiyabegamsk786@gmail.com", url = "https://your-website.com"), license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0")), externalDocs = @ExternalDocumentation(description = "Detailed Spring Boot service management documentation", url = "https://your-documentation-url.com"))

public class ServiceManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceManagementMicroserviceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
