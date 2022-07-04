package com.cts.sbd.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sbd.service.Counter;
import com.cts.sbd.service.GreetService;

@Component
public class HomeScreen implements CommandLineRunner {

	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;

	@Autowired
	@Qualifier("greetServiceAdvancedImpl")
	private GreetService greetService2;

	@Autowired
	@Qualifier("greetServiceEnhancedImpl")
	private GreetService greetService3;

	@Autowired
	private Counter c1;

	@Autowired
	private Counter c2;

	@Autowired
	private Counter c3;

	@Autowired
	private Scanner scanner;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello! This is spring ioc demo");

		System.out.println("Your Name?? ");
		String userName = scanner.next();

		System.out.println(greetService1.greet(userName));
		System.out.println(greetService2.greet(userName));
		System.out.println(greetService3.greet(userName));

		System.out.println(c1.next());
		System.out.println(c2.next());
		System.out.println(c3.next());
	}
}
