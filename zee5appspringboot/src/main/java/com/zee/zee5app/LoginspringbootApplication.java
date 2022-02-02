package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class LoginspringbootApplication {

	public static void main(String[] args) {
		
	ConfigurableApplicationContext applicationContext =	SpringApplication.run(LoginspringbootApplication.class, args);
	
//	DataSource dataSource = applicationContext.getBean(DataSource.class);
//	System.out.println(dataSource!=null);
//	
//	UserRepository userRepository  = applicationContext.getBean(UserRepository.class);
	
	System.out.println("Register table");
	
	LoginService service = applicationContext.getBean(LoginService.class);
	Login login;
	
	// ------addlogindetails----------
	login = new Login("gokulkm1@gmail.com", "abcd1234", "ab000001", ROLE.ROLE_USER);
	System.out.println(service.addCredentials(login));
	login = new Login("gokulkm2@gmail.com", "efgh1234", "ab000001", ROLE.ROLE_USER);
	System.out.println(service.addCredentials(login));
	
	
	//----------deletlogindetails---------

	System.out.println(service.deleteCredentials("gokulkm2@gmail.com"));
	
	applicationContext.close();
	
	}
	
	

}