package com.fatec.api_java_airquality.dtos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fatec.api_java_airquality.entities.Cidade;
import com.fatec.api_java_airquality.entities.Sensor;

public class CityWithMeasurementDTO {
	
	private CidadeDTO cidade;
	private SensorDTO sensor;
	private List<MeasurementDTO> measurement = new ArrayList<MeasurementDTO>();
	
	
	public CidadeDTO getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		BeanUtils.copyProperties(cidade, this.cidade);
	}
	public SensorDTO getSensor() {
		return sensor;
	}
	public void setSensor(Sensor sensor) {
		BeanUtils.copyProperties(sensor, this.sensor);
	}
	public List<MeasurementDTO> getMeasurement() {
		return measurement;
	}
	public void setMeasurementDTO(List<MeasurementDTO> measurement) {
		this.measurement = measurement;
	}
	
	public void addMeasurementDTO(MeasurementDTO measurement) {
		this.measurement.add(measurement);
	}
	
	
	
	
	

}
