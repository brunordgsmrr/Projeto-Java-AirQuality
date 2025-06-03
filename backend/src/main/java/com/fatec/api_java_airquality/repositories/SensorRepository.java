package com.fatec.api_java_airquality.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fatec.api_java_airquality.entities.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
	
	@Query(nativeQuery=true, value="SELECT tb_sensores.id, tb_sensores.name, tb_sensores.cidade_id FROM tb_sensores WHERE cidade_id = :cidadeId;")
	List<Sensor> findByCidadeId(int cidadeId);
	

}
