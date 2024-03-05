package com.foodapp.foodapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Food Application OPEN-API",version = "1.0.0",description = "Food Application API with Spring boot"),
servers = {
		@Server (url = "http://localhost:8080",description = " Development Food Application OPEN API url"),
		@Server (url = "http://localhost:8081",description = "Testing Food Application OPEN API url")
}
) 
public class FoodApplication {

	private static ConfigurableApplicationContext applicationContext;
	
	public static void main(String[] args) {
		applicationContext=SpringApplication.run(FoodApplication.class, args);
//		SpringApplication.exit(applicationContext, ()->0);
//		SpringApplication.exit(applicationContext);
//		System.exit(0);
	}

}
