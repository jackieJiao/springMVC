package com.jiao.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public String hello(){
		System.out.println("hello service");
		String hello= "hello";
		return hello;
	}
}
