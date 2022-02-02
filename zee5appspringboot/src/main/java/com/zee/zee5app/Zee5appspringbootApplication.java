package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		
	ConfigurableApplicationContext applicationContext =	SpringApplication.run(Zee5appspringbootApplication.class, args);
	
//	DataSource dataSource = applicationContext.getBean(DataSource.class);
//	System.out.println(dataSource!=null);
//	
//	UserRepository userRepository  = applicationContext.getBean(UserRepository.class);
	
	System.out.println("Register table");
	
	UserService service = applicationContext.getBean(UserService.class);
	Register register;
	
	// ------adduser----------
//	try {
//		register = new Register("ab000001","gokul1","km1","gokul1@gmail.com","ghij1234",null);
//		register.setContactnumber(new BigDecimal("9012345678"));
//		
//        System.out.println(service.addUser(register));
//	} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	
//	}
	
	//----------deleteuser---------
	try {
		System.out.println(service.deleteUserById("ab000002"));
	} catch (IdNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	applicationContext.close();
	
	}
	
	

}