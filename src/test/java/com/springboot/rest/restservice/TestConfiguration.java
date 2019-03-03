package com.springboot.rest.restservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import com.springboot.rest.restservice.service.ITaskService;

//@ComponentScan(basePackageClasses = { ITaskService.class })
@SpringBootApplication
public class TestConfiguration {
	public static void main(String[] args) {
		SpringApplication.run(TestConfiguration.class, args);
	}

}
