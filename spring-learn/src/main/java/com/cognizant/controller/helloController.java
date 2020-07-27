package com.cognizant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//@Controller
@RestController //@RestController is @Controller + @ResponseBody So 
				//either use @RestController , or @Controller with @ResponseBody annotation with each method.
public class helloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("Start sayHEllo");
		LOGGER.info("End SayHello");
		return "Hello";
		
	}

}
