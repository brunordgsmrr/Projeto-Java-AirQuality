package com.fatec.api_java_airquality.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CidadeDTO {	

    private int id;
    private String name;
    private String locality;
    private ProviderDTO provider;
    private List<InstrumentDTO> instruments;
    private List<SensorDTO> sensors;
    
    public CidadeDTO() {
    	
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
	public ProviderDTO getProvider() {
		return provider;
	}
	public void setProvider(ProviderDTO provider) {
		this.provider = provider;
	}
	public List<InstrumentDTO> getInstruments() {
		return instruments;
	}
	public void setInstruments(List<InstrumentDTO> instruments) {
		this.instruments = instruments;
	}
	public List<SensorDTO> getSensors() {
		return sensors;
	}
	public void setSensors(List<SensorDTO> sensors) {
		this.sensors = sensors;
	}
    
    

}
