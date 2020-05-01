package com.example.demo.controller;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@RequestMapping("/maths")
public class Add {

	
	 @RequestMapping("/sum/{a}/{b}")
	public int getSum(@PathVariable("a") int a,@PathVariable("b") int b) {
		 System.err.println("...........Add server-2............");
		return a+b;
	}
}
