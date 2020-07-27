package com.cognizant.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Service.countryService;
import com.cognizant.Service.Exception.countryNotFound;
import com.cognizant.model.*;
import com.cognizant.springlearn.SpringLearnApplication;
@RestController
public class countryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	//@Autowired
	//private countryService service;
	@GetMapping("/country")
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in", Country.class);
		return country;
		//as you have annotated with @RestController there is no need to do explicit json conversion. 
		//Just return a POJO 
		//and jackson serializer will take care of converting to json. It is equivalent to using @ResponseBody 
	}
	@GetMapping("/countries")
	public ArrayList<Country> getAllCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=(ArrayList<Country>)context.getBean("countryList");
		return list;
	}
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws countryNotFound{
		
		Country country=countryService.getCountry(code);
		return country;
		
	}

}
