package com.fatec.api_java_airquality.dtos;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fatec.api_java_airquality.entities.Cidade;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CidadeDTO {	

    private int id;
    private String name;
    private String locality;
    private List<SensorDTO> sensors;
    
    public CidadeDTO() {
    	
    }    
    
	public CidadeDTO(Cidade cidade) {
		BeanUtils.copyProperties(cidade, this); 
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	public List<SensorDTO> getSensors() {
		return sensors;
	}
	public void setSensors(List<SensorDTO> sensors) {
		this.sensors = sensors;
	}   
    

}
