package com.fatec.api_java_airquality.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
	
	private int id;
    private String name;
    private Parameter parameter;

}
