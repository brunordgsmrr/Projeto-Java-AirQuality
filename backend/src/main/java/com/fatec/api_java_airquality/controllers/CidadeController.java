package com.fatec.api_java_airquality.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.api_java_airquality.dtos.CidadeDTO;
import com.fatec.api_java_airquality.dtos.SensorDTO;
import com.fatec.api_java_airquality.services.CidadeService;

@RestController
@RequestMapping(value = "/api")
public class CidadeController {
	
	@Autowired
	CidadeService cidadeService;
	
	@GetMapping(value = "/todasCidades")
	public List<CidadeDTO> consultarTodasCidades() {		
		return cidadeService.consultarTodasCidades();
	}

	@PostMapping(value = "/adicionarCidadeMonitorada")
	public void adicionarCidadeMonitorada(@RequestBody CidadeDTO body){
		System.out.println(body.getId());
		System.out.println(body.getName());
		System.out.println(body.getLocality());
		
		for (SensorDTO sensorDTO : body.getSensors()) {
			System.out.println(sensorDTO.getId());
			System.out.println(sensorDTO.getName());
		}
		
		cidadeService.adicionarCidadeMonitorada(body);
	}
	
	@GetMapping(value = "/cidadeMonitoradas")
	public List<CidadeDTO> consultarCidadesMonitoradas(){
		return cidadeService.consultarCidadesMonitoradas();
	}
	
	

}
