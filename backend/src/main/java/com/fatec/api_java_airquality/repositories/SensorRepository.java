package com.fatec.api_java_airquality.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.api_java_airquality.entities.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
	

}
