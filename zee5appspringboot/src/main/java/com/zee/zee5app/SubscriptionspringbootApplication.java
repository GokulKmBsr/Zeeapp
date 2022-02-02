package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class SubscriptionspringbootApplication {

	public static void main(String[] args) {
		
	ConfigurableApplicationContext applicationContext =	SpringApplication.run(SubscriptionspringbootApplication.class, args);
	
//	DataSource dataSource = applicationContext.getBean(DataSource.class);
//	System.out.println(dataSource!=null);
//	
//	UserRepository userRepository  = applicationContext.getBean(UserRepository.class);
	
	System.out.println("Subscription table");
	
	SubscriptionService service = applicationContext.getBean(SubscriptionService.class);
	Subscription subscription;
	
	// ------addsubscription----------
	subscription = new Subscription("sub000001", "10/01/2022", 499.0f, "credit", "10/02/2022", "active", "monthly",
			"false", "ab000001");
	try {
		System.out.println(service.addSubscription(subscription));
	} catch (InvalidAmountException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	subscription = new Subscription("sub000002", "10/01/2020", 4999.0f, "credit", "10/02/2021", "inactive", "anually",
			"true", "ab000002");
	try {
		System.out.println(service.addSubscription(subscription));
	} catch (InvalidAmountException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
//	
//	//----------deletesubscription---------
//	try {
//		System.out.println(service.deleteSubscription("ab000002"));
//	} catch (IdNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	//----getsubscriptionbyid--
	Optional<Subscription> subscription1 = null;

	try {
		subscription1 = service.getSubscriptionById("sub000001");
		System.out.println(subscription1.get());
	} catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	//-----getallsubscription---
	Optional<List<Subscription>> optional;
	try {
		optional = service.getAllSubscription();
		if (optional.isEmpty()) {
			System.out.println("there are no records");
		} else {
			optional.get().forEach(e -> System.out.println(e));
		}
	} catch (InvalidIdLengthException | InvalidAmountException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	applicationContext.close();
	
	}
	
	

}