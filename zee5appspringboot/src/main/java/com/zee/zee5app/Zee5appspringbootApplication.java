package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

		register = new Register("ab000001","gokul1","km1","gokul1@gmail.com","abcd1234",null);
		register.setContactnumber(new BigDecimal("1234567890"));
		System.out.println(service.addUser(register));
		register = new Register("ab000002","gokul2","km2","gokul2@gmail.com","efgh1234",null);
		register.setContactnumber(new BigDecimal("2345678901"));
        System.out.println(service.addUser(register));
        
        
	
	
	//----------deleteuser---------
	try {
		System.out.println(service.deleteUserById("ab000002"));
	} catch (IdNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
        // -----getuserbyid------
        Optional<Register> register1 = null;

		try {
			register1 = service.getUserById("ab000001");
			if (register1 != null) {
				System.out.println("Record found");
				System.out.println(register1.get());
			} else {
				System.out.println("record is not found");
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidEmailException | InvalidPasswordException
				| InvalidNameException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
		
		// ----------getallusers-------
		try {
			for (Register register2 : service.getAllUsers()) {
				if (register2 != null)
					System.out.println(register2);
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//--------getalluserdetails------
		Optional<List<Register>> optional1;
		try {
			optional1 = service.getAllUserDetails();
			if (optional1.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional1.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
       
	applicationContext.close();
	
	}
	
	

}