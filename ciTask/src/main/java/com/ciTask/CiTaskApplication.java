package com.ciTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CiTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(CiTaskApplication.class, args);
	}

}
