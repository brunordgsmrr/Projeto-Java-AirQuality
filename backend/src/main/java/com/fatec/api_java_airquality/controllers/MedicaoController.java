package com.fatec.api_java_airquality.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.api_java_airquality.services.MedicaoService;

@RestController
@RequestMapping(value = "/api")
public class MedicaoController {
	
	@Autowired
	MedicaoService medicaoService;
	
	@GetMapping(value="/medicao")
	public void getMedicao() {
		
	}
	
	

}
