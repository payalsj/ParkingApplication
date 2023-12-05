package com.parking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI registrationOpenAPI() {
		return new OpenAPI().info(
				new Info().title("Car Parking Application").description("Car Parking Application").version("1.0"));
	}

}
