package com.fatec.api_java_airquality.dtos;

import java.util.ArrayList;
import java.util.List;

public class CityWithMeasurementDTO {
	
	private CidadeDTO cidade;
	private List<MeasurementDTO> measurement = new ArrayList<MeasurementDTO>();
	
	
	public CidadeDTO getCidade() {
		return cidade;
	}
	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
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
