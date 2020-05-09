package com.example.demo.controller;

import org.apache.log4j.Logger;
//import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logging.AppLogger;

@EnableDiscoveryClient
@RestController
@RequestMapping("/maths")
public class Add {

	private static final Logger LOG = Logger.getLogger(Add.class.getName());
	@Autowired
	AppLogger appLogger;
	
	 @RequestMapping("/sum/{a}/{b}")
	public int getSum(@PathVariable("a") int a,@PathVariable("b") int b) {
		    appLogger.appInfoLog("...........Add server-2.............");
		return a+b;
	}
}
