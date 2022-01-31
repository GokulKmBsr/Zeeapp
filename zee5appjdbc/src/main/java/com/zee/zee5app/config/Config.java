package com.zee.zee5app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration //it is used to mark on config class/classes
//here we will hold all commonly required objects for our application

@ComponentScan("com.zee.zee5app")
@PropertySource("classpath:application.properties") //it is responsible to read the property file
public class Config {
	
	@Autowired //will bring the already created objects based on the name(ref name) or type
	Environment environment; //this implementation object is prepared by spring
	//do we need to inject that already created objets?yes ==> DI ==>IoC
	
	//config : db related ,reading prop file,commonly reqd beans (password encoder)
	
	@Bean //provide the singleton
	public DataSource dataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
		
		return basicDataSource;
	}

}
