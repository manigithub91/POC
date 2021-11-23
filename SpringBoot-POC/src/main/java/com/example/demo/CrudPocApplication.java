package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customer API", version = "2.0", description = "Customer Information"))

public class CrudPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudPocApplication.class, args);
	}

}
