package com.cts.siocdemo;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cts.siocdemo")
@PropertySource("classpath:app.properties")
public class SpringIocDemoConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
