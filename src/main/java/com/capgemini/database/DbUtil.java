package com.capgemini.database;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:file.properties")
public class DbUtil {

	
	@Autowired
	private Environment env; 
	
//
//
//	@Bean(name="dbconfig")
//	public DbConfig getDbConfig() {
		
//		return dbConfig;
//		
//		
//	}	
//	@Bean(name="dbconfig")
	public Connection getConnection() {
		DbConfig dbConfig = new DbConfig();
		dbConfig.setDbPassword(env.getProperty("password"));
		dbConfig.setDbUser(env.getProperty("user"));
		dbConfig.setDbUrl(env.getProperty("url"));
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbConfig.getDbUrl(),dbConfig.getDbUser(),dbConfig.getDbPassword());
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
