package com.fatec.api_java_airquality.entities;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fatec.api_java_airquality.dtos.CidadeDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cidade")
public class Cidade {
	
	@Id
	private int id;
	
    private String name;
    private String locality;
    
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;
    
    @ManyToMany
    @JoinTable(
        name = "tb_cidade_instrumento",
        joinColumns = @JoinColumn(name = "cidade_id"),
        inverseJoinColumns = @JoinColumn(name = "instrumento_id")
    )
    private List<Instrument> instruments;
    
    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private List<Sensor> sensors;
    
    
	public Cidade() {
	}
	
	public Cidade(CidadeDTO cidadeDTO) {
		BeanUtils.copyProperties(cidadeDTO, this);
	}
	
	

	public Cidade(int id, String name, String locality, Provider provider, List<Instrument> instruments,
			List<Sensor> sensors) {
		this.id = id;
		this.name = name;
		this.locality = locality;
		this.provider = provider;
		this.instruments = instruments;
		this.sensors = sensors;
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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	
	
    
    
   
}
