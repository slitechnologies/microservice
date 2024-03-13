package com.manaba.jobsmicroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "MANA_JOBS", version = "1.01", description = "MANABA JOB API DOCUMENTATION SCHEMA"))
@SpringBootApplication
public class JobsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobsMicroserviceApplication.class, args);
	}

}
