package com.cognizant.Service.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Country Not Found")
public class countryNotFound extends Exception{

}
