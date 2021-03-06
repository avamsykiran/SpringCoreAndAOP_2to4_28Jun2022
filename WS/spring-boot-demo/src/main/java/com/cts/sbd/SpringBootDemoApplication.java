package com.cts.sbd;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		//we have no application context
		SpringApplication.run(SpringBootDemoApplication.class, args);
		//the application context is killed.
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
