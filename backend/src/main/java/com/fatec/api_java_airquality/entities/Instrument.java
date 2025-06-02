package com.fatec.api_java_airquality.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_instruments")
public class Instrument {
	
	@Id
	private int id;
    private String name;
    
    @ManyToMany(mappedBy = "instruments")
    private List<Cidade> cidades;
    
	public Instrument() {
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
