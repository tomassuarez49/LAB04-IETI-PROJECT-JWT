package com.edu.eci.ieti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.edu.eci.ieti")
public class IetiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IetiApplication.class, args);
	}

}
