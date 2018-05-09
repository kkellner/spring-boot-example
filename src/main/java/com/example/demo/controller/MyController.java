package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MyController {


	@RequestMapping(value = "", method = RequestMethod.GET)
	public String hello() {
		
		System.out.println("Log message from Hello World");
		return "Hello World";
	}

	
}
