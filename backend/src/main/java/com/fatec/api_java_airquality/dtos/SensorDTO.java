package com.fatec.api_java_airquality.dtos;

public class SensorDTO {
	private int id;
    private String name;
    private ParameterDTO parameter;
    
    public SensorDTO() {
    	
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

	public ParameterDTO getParameter() {
		return parameter;
	}

	public void setParameter(ParameterDTO parameter) {
		this.parameter = parameter;
	}
    
    

}
