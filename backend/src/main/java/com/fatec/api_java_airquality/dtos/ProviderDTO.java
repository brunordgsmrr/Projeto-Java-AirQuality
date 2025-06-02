package com.fatec.api_java_airquality.dtos;

import org.springframework.beans.BeanUtils;

import com.fatec.api_java_airquality.entities.Provider;

public class ProviderDTO {
	

    private int id;
    private String name;
    
    public ProviderDTO() {
    	
    }
    
    public ProviderDTO(Provider provider) {
    	BeanUtils.copyProperties(provider, this);
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
