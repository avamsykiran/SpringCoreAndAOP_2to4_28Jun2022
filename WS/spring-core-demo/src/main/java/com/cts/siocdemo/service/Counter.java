package com.cts.siocdemo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Counter {

	@Value("${count.init:0}")
	private int count;
	
	public int next() {
		return ++count;
	}
}
