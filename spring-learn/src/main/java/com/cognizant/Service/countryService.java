package com.cognizant.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.Service.Exception.*;
import com.cognizant.Service.Exception.countryNotFound;
import com.cognizant.model.Country;
import com.cognizant.springlearn.SpringLearnApplication;

public class countryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static  Country getCountry(String code) throws countryNotFound {
		LOGGER.debug(code);
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=(ArrayList<Country>)context.getBean("countryList");
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getCode().equalsIgnoreCase(code)) {
				return list.get(i);
			}
		}
		LOGGER.debug("nhi mila");
		throw new countryNotFound();
		
		
	}
}
