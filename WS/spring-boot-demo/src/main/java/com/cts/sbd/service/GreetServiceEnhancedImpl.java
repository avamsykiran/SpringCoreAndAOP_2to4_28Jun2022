package com.cts.sbd.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceEnhancedImpl implements GreetService {

	@Value("${greet.note:Namasthey}")
	private String greetNote;
	
	@Override
	public String greet(String userName) {
		return greetNote + " "+userName;
	}

}
