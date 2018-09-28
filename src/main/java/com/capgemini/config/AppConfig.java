package com.capgemini.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration
@ComponentScan(basePackages = { "com.capgemini" })
@PropertySource("classpath:file.properties")
public class AppConfig {
	@Value("${driver}")
	private String driver;
	
	@Value("${url}")
	private String url;
	
	@Value("${user}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	
@Bean
public DataSource getDataSource() {
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName(driver);
	dataSource.setUsername(username);
	dataSource.setPassword(password);
	dataSource.setUrl(url);
	return dataSource;
}

@Bean
public JdbcTemplate getJdbcTemplate() {
	JdbcTemplate jdbcTemplate=new JdbcTemplate();
	jdbcTemplate.setDataSource(getDataSource());
	return jdbcTemplate;
}
	
	
}
