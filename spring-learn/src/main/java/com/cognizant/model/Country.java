package com.cognizant.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.springlearn.SpringLearnApplication;
public class Country {
	private String code;
	private String name;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public Country() {
		super();
		// TODO Auto-generated constructor stub
		LOGGER.debug("Inside Country Constructor.");
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	public String getName() {
		LOGGER.debug("getterName");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("setterName");
		this.name = name;
	}
	public String getCode() {
		LOGGER.debug("getterCode");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("setterCode");
		this.code = code;
	}
	
}
