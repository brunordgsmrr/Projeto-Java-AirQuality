package com.fatec.api_java_airquality.dtos;

public class ParameterDTO {
	
	private int id;
	private String name;
	private String units;
	private String displayName;
	private String description;
	
	
	public ParameterDTO() {
	}
	
	public ParameterDTO(int id, String name, String units, String displayName, String description) {
		this.id = id;
		this.name = name;
		this.units = units;
		this.displayName = displayName;
		this.description = description;
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
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	

}
