package com.fatec.api_java_airquality.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
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
import com.fatec.api_java_airquality.dtos.CityWithMeasurementDTO;
import com.fatec.api_java_airquality.dtos.MeasurementDTO;
import com.fatec.api_java_airquality.dtos.SensorDTO;
import com.fatec.api_java_airquality.entities.Cidade;
import com.fatec.api_java_airquality.entities.Sensor;
import com.fatec.api_java_airquality.repositories.CidadeRepository;
import com.fatec.api_java_airquality.repositories.SensorRepository;

@Service
public class CidadeService {
	
	@Autowired
    private CidadeRepository cidadeRepository;
	
	@Autowired
    private SensorRepository sensorRepository;

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

	public void removerCidadeMonitorada(int id) {
		cidadeRepository.deleteById(id);
		
	}

	public CityWithMeasurementDTO consultarDadosMedicao(int cityId) {		
		
		Cidade cidade = cidadeRepository.findById(cityId).orElse(null);		
		Sensor sensor = new Sensor();
		sensor.setCidade(cidade);		
		List<Sensor> sensores = sensorRepository.findAll(Example.of(sensor));
		
		CityWithMeasurementDTO cityWithMeasurementDTO = new CityWithMeasurementDTO();
		cityWithMeasurementDTO.setCidade(cidade);
		cityWithMeasurementDTO.setSensor(sensor);
		
		
		RestTemplate restTemplate = new RestTemplate();
	    ObjectMapper objectMapper = new ObjectMapper();
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("X-API-Key", API_KEY);
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		for (Sensor sensorAtual : sensores) {
			
			String req = BASE_URL + "/sensors/" + sensorAtual.getId() + "/days/monthly";
			
			ResponseEntity<String> response = restTemplate.exchange(req, HttpMethod.GET, requestEntity, String.class);
			
			if (response.getStatusCode().is2xxSuccessful()) {
	            try {
	                JsonNode root = objectMapper.readTree(response.getBody());
	                JsonNode resultsNode = root.get("results");
	                
	                
	                if (resultsNode.isArray()) {
	                	for (JsonNode jsonNode: resultsNode) {
	                		
	                		MeasurementDTO measurementDTO = new MeasurementDTO();	                		
	                		
	                		double value = jsonNode.get("value").asDouble();
	                        String parameterName = jsonNode.get("parameter").get("name").asText();
	                        String units = jsonNode.get("parameter").get("units").asText();
	                        LocalDate period = LocalDate.parse(jsonNode.get("period").get("datetimeFrom").get("local").asText());
	                        
	                        measurementDTO.setValue(value);
	                        measurementDTO.setParameterName(parameterName);
	                        measurementDTO.setUnits(units);
	                        measurementDTO.setPeriod(period);
	                        
	                        cityWithMeasurementDTO.addMeasurementDTO(measurementDTO);	                        
	                	}
	                }
	            } catch (JsonProcessingException e) {
	                e.printStackTrace();
	            }
	        }

		}
		return cityWithMeasurementDTO;
	}

}
