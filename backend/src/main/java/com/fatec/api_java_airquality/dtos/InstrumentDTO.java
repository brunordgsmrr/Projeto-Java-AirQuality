package com.fatec.api_java_airquality.dtos;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fatec.api_java_airquality.entities.Cidade;
import com.fatec.api_java_airquality.entities.Instrument;

public class InstrumentDTO {
	
	private int id;
    private String name;
    private List<Cidade> cidades;
    
    public InstrumentDTO() {
    	
    }
    
    public InstrumentDTO(Instrument instrument) {
    	BeanUtils.copyProperties(instrument, this);    	
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

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
    
    

}
