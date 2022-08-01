package com.logica.rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LogicaRhApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogicaRhApplication.class, args);
	}
	//http://localhost:8889/swagger-ui/index.html

}
