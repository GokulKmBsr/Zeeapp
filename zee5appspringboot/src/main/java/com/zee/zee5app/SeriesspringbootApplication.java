//package com.zee.zee5app;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Optional;
//
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import com.zee.zee5app.dto.User;
//import com.zee.zee5app.dto.Series;
//import com.zee.zee5app.exception.IdNotFoundException;
//import com.zee.zee5app.exception.InvalidEmailException;
//import com.zee.zee5app.exception.InvalidIdLengthException;
//import com.zee.zee5app.exception.InvalidNameException;
//import com.zee.zee5app.exception.InvalidPasswordException;
//import com.zee.zee5app.exception.NameNotFoundException;
//import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.service.SeriesService;
//import com.zee.zee5app.service.UserService;
//
//@SpringBootApplication
//public class SeriesspringbootApplication {
//
//	public static void main(String[] args) {
//		
//	ConfigurableApplicationContext applicationContext =	SpringApplication.run(SeriesspringbootApplication.class, args);
////	
//////	DataSource dataSource = applicationContext.getBean(DataSource.class);
//////	System.out.println(dataSource!=null);
//////	
//////	UserRepository userRepository  = applicationContext.getBean(UserRepository.class);
////	
////	System.out.println("Series table");
////	
////	SeriesService service = applicationContext.getBean(SeriesService.class);
////	Series series;
////	
////	// ------addseries----------
//////	series = new Series("ser000001", "ABC", "a,b", "10/01/2022", null, "english", "10", "action", 30);
//////	System.out.println(service.addSeries(series));
//////	series = new Series("ser000002", "XYZ", "c,d", "20/01/2022", null, "kannada", "18", "thriller", 59);
//////	System.out.println(service.addSeries(series));
//////	
////	//----------deleteseries---------
////	try {
////		System.out.println(service.deleteSeries("ser000002"));
////	} catch (IdNotFoundException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
////	
////	//---getseriesbyid---
////	Optional<Series> series1 = null;
////
////		try {
////			series1 = service.getSeriesById("ser000001");
////			System.out.println(series1.get());
////		} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////	
////	//----getallseries--
////		Optional<List<Series>> optional;
////		try {
////			optional = service.getAllSeries();
////			if (optional.isEmpty()) {
////				System.out.println("no series");
////			} else {
////				optional.get().forEach(e -> System.out.println(e));
////			}
////		} catch (NameNotFoundException | InvalidIdLengthException e2) {
////			// TODO Auto-generated catch block
////			e2.printStackTrace();
////		}
////	
////	applicationContext.close();
////	
//	}
//	
//	
//
//}