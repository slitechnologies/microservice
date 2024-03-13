package com.manaba.reviewsmicroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(info = @Info(title = "MANA_JOBS", version = "1.0.1", description = "MANABA JOB API DOCUMENTATION SCHEMA"))
@SpringBootApplication
public class ReviewsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsMicroserviceApplication.class, args);
	}

}
