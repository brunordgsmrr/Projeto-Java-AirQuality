package com.fatec.api_java_airquality.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;

public class DbConnection {	
	
	@Value("${database.url}")
	private static final String URL = "";
	
	@Value("${database.username}")
    private static final String USUARIO = "";
	
	@Value("${database.password}")
    private static final String SENHA = "";

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

}
