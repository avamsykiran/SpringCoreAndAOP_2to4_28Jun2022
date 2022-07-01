package com.cts.siocdemo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceAdvancedImpl implements GreetService {

	@Override
	public String greet(String userName) {
		String greetNote = "";
		
		int h = LocalDateTime.now().getHour();
		
		if(h>=4 && h<=11) greetNote="Good Morning";
		else if(h>=12 && h<=16) greetNote="Good Noon";
		else greetNote="Good Evening";
		
		return greetNote + " "+userName;
	}

}
