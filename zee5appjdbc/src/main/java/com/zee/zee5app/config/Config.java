package com.zee.zee5app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.zee.zee5app.utils1.PasswordUtils;

@Configuration //it is used to mark on config class/classes
//here we will hold all commonly required objects for our application

@ComponentScan("com.zee.zee5app")
@PropertySource("classpath:application.properties") //it is responsible to read the property file
public class Config {
	
	@Autowired //will bring the already created objects based on the name(ref name) or type
	Environment environment; //this implementation object is prepared by spring
	//do we need to inject that already created objets?yes ==> DI ==>IoC
	
	//config : db related ,reading prop file,commonly reqd beans (password encoder)
	
	@Bean(name= "ds") //provide the singleton
	@Scope("prototype")  //if u will call getBean method n number of times then u will get N objects
	// prototype -- to get multiple odject
	//if we will not specify the bean name then it will take or consider the method name as a bean name
	public DataSource dataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
		
		return basicDataSource;
	}
	
	@Bean  //are we going to create the object? yes
	//this object can we initialize as per the req?
	//can we custamize it as an when req ? in case of bean 
	public PasswordUtils passwordUtils() {
		// TODO Auto-generated method stub
		return new PasswordUtils();

	}

}
