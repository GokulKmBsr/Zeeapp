package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;

public class MainSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//do we need to establish or create spring env?
		//yes : this one will kick start of our spring application
		//application context
		//here we have to initialize the application context container
		//java based config
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		DataSource dataSource = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource.hashCode());
		DataSource dataSource2 = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource2.hashCode());
		System.out.println(dataSource.equals(dataSource2));
		
		
//		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
//		System.out.println(userRepository);
//		UserRepository userRepository2 = applicationContext.getBean(UserRepository.class);
//		System.out.println(userRepository2);
//		
//		System.out.println(userRepository.hashCode());
//		System.out.println(userRepository.hashCode());
//		System.out.println(userRepository.equals(userRepository2));
//		
//		
//		DataSource dataSource = applicationContext.getBean("dataSource",DataSource.class);
//		System.out.println(dataSource!=null);
//		
//		Register register;
//		
//		try {
//				register = new Register("ab000008","gokul8","km8","gokul8@gmail.com","cdef1234",null);
//				register.setContactnumber(new BigDecimal("8901234567"));
//				System.out.println(userRepository.addUser(register));
//			} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
//					| InvalidPasswordException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		
		
		applicationContext.close();

	}

}
