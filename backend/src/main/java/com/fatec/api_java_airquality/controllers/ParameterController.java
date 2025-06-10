package com.fatec.api_java_airquality.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.api_java_airquality.dtos.ParameterDTO;
import com.fatec.api_java_airquality.services.ParameterService;

@RestController
@RequestMapping(value="/api")
public class ParameterController {
	
	@Autowired
	ParameterService parameterService;
	
	@GetMapping(value="/parameters")
	public List<ParameterDTO> getParameters(){
		
		return parameterService.getParameters();
		
	}

}
