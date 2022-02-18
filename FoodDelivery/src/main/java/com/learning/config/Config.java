package com.learning.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.learning.utils.PasswordUtils;

@Configuration
public class Config {
	
	@Autowired //it will bring the already created objects based on the name(reference name)/type
	Environment environment;
	@Bean
	public PasswordUtils passwordUtils() {
		return new PasswordUtils();
	}

}
