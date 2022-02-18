//package com.zee.zee5app;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Optional;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import com.zee.zee5app.dto.Episode;
//import com.zee.zee5app.dto.User;
//import com.zee.zee5app.exception.IdNotFoundException;
//import com.zee.zee5app.exception.InvalidEmailException;
//import com.zee.zee5app.exception.InvalidIdLengthException;
//import com.zee.zee5app.exception.InvalidNameException;
//import com.zee.zee5app.exception.InvalidPasswordException;
//import com.zee.zee5app.exception.NameNotFoundException;
//import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.service.EpisodeService;
//import com.zee.zee5app.service.UserService;
//
//@SpringBootApplication
//public class EpisodespringbootApplication {
//
//	public static void main(String[] args) {
//		
//	ConfigurableApplicationContext applicationContext =	SpringApplication.run(EpisodespringbootApplication.class, args);
////	
//////	DataSource dataSource = applicationContext.getBean(DataSource.class);
//////	System.out.println(dataSource!=null);
//////	
//////	UserRepository userRepository  = applicationContext.getBean(UserRepository.class);
////	
////	System.out.println("episode table");
////	
////	EpisodeService service = applicationContext.getBean(EpisodeService.class);
////	Episode episode;
////	
////	// ------addepisode----------
////	episode = new Episode("epi000001", "abc", 35, "ser000001","india",null);
////	System.out.println(service.addEpisode(episode));
////	episode = new Episode("epi000002", "xyz", 35, "ser000002","india",null);
////	System.out.println(service.addEpisode(episode));
////	
////	//----------deleteepisode---------
////	try {
////		System.out.println(service.deleteEpisode("epi000002"));
////	} catch (IdNotFoundException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
////	
////	
////	//----------getepisodebyid-------
////	Optional<Episode> episode1 = null;
////
////	try {
////		episode1 = service.getEpisodeById("epi000001");
////		System.out.println(episode1.get());
////	} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e1) {
////		// TODO Auto-generated catch block
////		e1.printStackTrace();
////	}
////	
////	//---------getallepisode--
////	Optional<List<Episode>> optional;
////	try {
////		optional = service.getAllEpisode();
////		if (optional.isEmpty()) {
////			System.out.println(" no episode");
////		} else {
////			optional.get().forEach(e -> System.out.println(e));
////		}
////	} catch (InvalidIdLengthException e1) {
////		// TODO Auto-generated catch block
////		e1.printStackTrace();
////	}
////	
////	applicationContext.close();
////	
//	}
//	
//	
//
//}