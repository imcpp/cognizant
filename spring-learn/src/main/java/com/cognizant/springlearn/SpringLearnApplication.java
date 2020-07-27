package com.cognizant.springlearn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


import com.cognizant.model.*;


@SpringBootApplication
@ComponentScan(basePackages = {"com.cognizant"})
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		//displayDate();
		//displayCountry();
		//displayCountries();
		
		
	}
	
	public static void displayDate() throws ParseException {
		LOGGER.info("Start");
		ApplicationContext context=new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		//System.out.println(format.parse("31/12/2018"));
		LOGGER.debug(format.parse("31/12/2018").toString());
		LOGGER.info("End");	
	}
	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in", Country.class);
		//Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
	}
	public static void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=(ArrayList<Country>)context.getBean("countryList");
		LOGGER.debug(list.toString());
		
	}

}



