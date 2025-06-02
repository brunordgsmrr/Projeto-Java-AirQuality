package com.fatec.api_java_airquality.dtos;

import java.time.LocalDate;

public class MeasurementDTO {
	
	private double value;
	private String parameterName;
	private String units;
	private LocalDate period;
	
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public LocalDate getPeriod() {
		return period;
	}
	public void setPeriod(LocalDate period) {
		this.period = period;
	}
	
	

}
