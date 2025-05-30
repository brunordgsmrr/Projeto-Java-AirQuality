package com.fatec.api_java_airquality.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.api_java_airquality.dtos.CidadeDTO;
import com.fatec.api_java_airquality.services.CidadeService;

@RestController
@RequestMapping(value = "/api")
public class CidadeController {
	
	@Autowired
	CidadeService cityService;
	
	@GetMapping(value = "/allcities")
	public List<CidadeDTO> getAllCities() {
		
		return cityService.getAllCities();
	}

}
