package com.logica.rh;

import com.logica.rh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LogicaRhApplication {
	@Autowired
	private EmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(LogicaRhApplication.class, args);
	}
	//http://localhost:8889/swagger-ui/index.html

}
