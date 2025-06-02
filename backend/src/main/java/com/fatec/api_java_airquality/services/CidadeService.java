package com.fatec.api_java_airquality.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fatec.api_java_airquality.dtos.CidadeDTO;
import com.fatec.api_java_airquality.dtos.SensorDTO;
import com.fatec.api_java_airquality.entities.Cidade;
import com.fatec.api_java_airquality.entities.Sensor;
import com.fatec.api_java_airquality.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
    private CidadeRepository cidadeRepository;

	@Value("${openaq.api.url}")
	private String BASE_URL;

	@Value("${openaq.api.key}")
	private String API_KEY;

	public List<CidadeDTO> consultarTodasCidades() {

		RestTemplate restTemplate = new RestTemplate();
	    ObjectMapper objectMapper = new ObjectMapper();

		HttpHeaders headers = new HttpHeaders();

		headers.set("X-API-Key", API_KEY);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/locations?countries_id=45", HttpMethod.GET,
				requestEntity, String.class);
		
		if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode root = objectMapper.readTree(response.getBody());
                JsonNode resultsNode = root.get("results");
                
                return objectMapper.readValue(resultsNode.toString(), new TypeReference<List<CidadeDTO>>() {});

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

		return Collections.emptyList();

	}
	
	public void adicionarCidadeMonitorada(CidadeDTO cidadeDTO) {
		
		Cidade cidade = new Cidade();

		cidade.setId(cidadeDTO.getId());
		cidade.setName(cidadeDTO.getName());
		cidade.setLocality(cidadeDTO.getLocality());
		
		List<Sensor> sensores = new ArrayList<Sensor>();
		
		for (SensorDTO sensorDTO : cidadeDTO.getSensors()) {
			Sensor sensor = new Sensor();
			sensor.setId(sensorDTO.getId());
			sensor.setName(sensorDTO.getName());
			sensor.setCidade(cidade);
			sensores.add(sensor);
		}
		
		cidade.setSensors(sensores);
		
		cidadeRepository.save(cidade);
	}
	
	
	public List<CidadeDTO> consultarCidadesMonitoradas() {
		
		List<Cidade> result = cidadeRepository.findAll();
		
		List<CidadeDTO> cidadesDTO = result.stream().map(cidade -> new CidadeDTO(cidade)).toList();
		
		return cidadesDTO;
    }

}
