package com.fatec.api_java_airquality.services;

import java.util.Collections;
import java.util.List;

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

@Service
public class CidadeService {

	@Value("${openaq.api.url}")
	private String BASE_URL;

	@Value("${openaq.api.key}")
	private String apiKey;

	public List<CidadeDTO> getAllCities() {

		RestTemplate restTemplate = new RestTemplate();
	    ObjectMapper objectMapper = new ObjectMapper();

		HttpHeaders headers = new HttpHeaders();

		headers.set("X-API-Key", apiKey);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/locations?countries_id=45", HttpMethod.GET,
				requestEntity, String.class);
		
		if (response.getStatusCode().is2xxSuccessful()) {
            try {
                JsonNode root = objectMapper.readTree(response.getBody());
                JsonNode resultsNode = root.get("results");
                
                return objectMapper.readValue(resultsNode.toString(), new TypeReference<List<CidadeDTO>>() {});
                
                
//                for (JsonNode node : root.get("results")) {
//                    String name = node.get("name").asText();
//                    System.out.println("Name: " + name);
//                }

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

		return Collections.emptyList();

	}

}
