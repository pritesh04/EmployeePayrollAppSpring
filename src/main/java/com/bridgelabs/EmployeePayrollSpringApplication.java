package com.bridgelabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context=  SpringApplication.run(EmployeePayrollSpringApplication.class, args);
		log.info("AddressBookApp started in {} Envoronment", context.getEnvironment().getProperty("environment"));
	}

}
