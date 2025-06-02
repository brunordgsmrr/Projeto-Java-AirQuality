package com.fatec.api_java_airquality.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.api_java_airquality.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {
	

}
