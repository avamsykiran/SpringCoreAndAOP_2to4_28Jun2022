package com.cts.siocdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.siocdemo.ui.HomeScreen;

public class SpringIocDemoApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringIocDemoConfig.class);
		
		HomeScreen hs = (HomeScreen) context.getBean("homeScreen");
		hs.run();
	}

}
