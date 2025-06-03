package com.fatec.api_java_airquality.dtos;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fatec.api_java_airquality.entities.Sensor;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorDTO {
	private int id;
    private String name;
    
    public SensorDTO() {
    	
    }
    
    public SensorDTO(Sensor sensor) {
    	BeanUtils.copyProperties(sensor, this);
    	
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
    

}
