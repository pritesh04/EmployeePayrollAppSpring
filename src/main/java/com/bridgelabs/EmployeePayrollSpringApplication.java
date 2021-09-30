package com.bridgelabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollSpringApplication.class, args);
		log.error("Error generated ");
	}

}
