//package com.zee.zee5app;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import com.zee.zee5app.dto.EROLE;
//import com.zee.zee5app.dto.Episode;
//import com.zee.zee5app.dto.Movie;
//import com.zee.zee5app.dto.User;
//import com.zee.zee5app.dto.Role;
//import com.zee.zee5app.dto.Series;
//import com.zee.zee5app.dto.Subscription;
//import com.zee.zee5app.exception.AlreadyExistsException;
//import com.zee.zee5app.exception.IdNotFoundException;
//import com.zee.zee5app.exception.InvalidAmountException;
//import com.zee.zee5app.exception.InvalidIdLengthException;
//import com.zee.zee5app.exception.NameNotFoundException;
//import com.zee.zee5app.repository.MovieRepository;
//import com.zee.zee5app.repository.RoleRepository;
//import com.zee.zee5app.repository.SeriesRepository;
//import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.service.EpisodeService;
//import com.zee.zee5app.service.MovieService;
//import com.zee.zee5app.service.RoleService;
//import com.zee.zee5app.service.SeriesService;
//import com.zee.zee5app.service.SubscriptionService;
//import com.zee.zee5app.service.UserService;
//
//@SpringBootApplication
//public class Main2 {
//
//	public static void main(String[] args) throws AlreadyExistsException, InvalidAmountException {
//		// TODO Auto-generated method stub
//		
//		ConfigurableApplicationContext applicationContext =	SpringApplication.run(Zee5appspringbootApplication.class, args);
//		
////		Role role = new Role();
////		role.setRoleName(EROLE.ROLE_ADMIN);
////		
////		Role role2 = new Role();
////		role2.setRoleName(EROLE.ROLE_USER); 
//		
////		RoleService roleService = applicationContext.getBean(RoleService.class);
////		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
//		
////		System.out.println(roleService.addRole(role));
////		System.out.println(roleService.addRole(role2));
//		
////		
////		UserService service = applicationContext.getBean(UserService.class);
////		Register register;
////		register = new Register("ab000006","gokul6","km6","gokul6@gmail.com","ijkl1234",null, null);
////		register.setContactnumber(new BigDecimal("1234567890"));
////		Set<Role> roles = new HashSet<>();
////		roles.add(roleRepository.findById(1).get());
////		roles.add(roleRepository.findById(2).get());
////		register.setRoles(roles);
////		System.out.println(service.addUser(register));
////		
//		//		UserService service = applicationContext.getBean(UserService.class);
////		Register register;
////		
////		// ------adduser----------
////
////			register = new Register("ab000005","gokul5","km5","gokul5@gmail.com","ijkl1234",null, null);
////			register.setContactnumber(new BigDecimal("1234567890"));
////			System.out.println(service.addUser(register));
////			register = new Register("ab000004","gokul4","km4","gokul4@gmail.com","efgh1234",null);
////			register.setContactnumber(new BigDecimal("2345678901"));
////	        System.out.println(service.addUser(register));
//		//UserRepository userRepository = applicationContext.getBean(UserRepository.class);
//		//System.out.println(userRepository.existsByEmailAndContactnumber("gokul1@gmail.com",new BigDecimal("1234567890")));
//	        
//		
//////------------------movie---------		
////		System.out.println("Movie table");
////		
////		MovieService service = applicationContext.getBean(MovieService.class);
////		Movie movie;
////		
////		// ------addmovie----------
////		movie = new Movie("mov000001", "kgf", "A,B,C", 120, "10/01/2022", null, "kannada", "18", "action");
////		System.out.println(service.addMovie(movie));
////		movie = new Movie("mov000002", "pushpa", "A,B,C", 130, "20/01/2022", null, "kannada", "18", "action");
////		System.out.println(service.addMovie(movie));
////		MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);
////		//System.out.println(movieRepository.existsByMoviename("kgf"));
////		//System.out.println(movieRepository.findByMoviename("kgf"));
////		//System.out.println(movieRepository.findByMovienameAndLanguage("kgf","kannada"));
////		//System.out.println(movieRepository.findByMovienameAndReleaseDate("kgf","10/01/2022"));
////		System.out.println(movieRepository.findByCast("A,B,C"));
////		
////		
//////-------------series-----------
////		
//////		System.out.println("Series table");
//////		
//////		SeriesService service = applicationContext.getBean(SeriesService.class);
//////		Series series;
//////		
//////		// ------addseries----------
//////		series = new Series("ser000001", "ABC", "a,b", "10/01/2022", null, "english", "10", "action", 30);
//////		System.out.println(service.addSeries(series));
//////		series = new Series("ser000002", "XYZ", "c,d", "20/01/2022", null, "kannada", "18", "thriller", 59);
//////		System.out.println(service.addSeries(series));
//////		
//////		SeriesRepository seriesRepository = applicationContext.getBean(SeriesRepository.class);
//////		System.out.println(seriesRepository.findBySeriesnameAndLanguage("XYZ","kannada"));
////		
//		
//		//RoleService roleService = applicationContext.getBean(RoleService.class);
//		//RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
////		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
////		Series series1,series2;
////		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
////		//Episode episode;
////		series1 = new Series("ser000001", "ABC", "a,b", "10/01/2022", null, "english", "10", "action", 30,null);
//////		System.out.println(seriesService.addSeries(series));
////		series2 = new Series("ser000002", "XYZ", "c,d", "20/01/2022", null, "kannada", "18", "thriller", 59,null);
//////		System.out.println(seriesService.addSeries(series));
////		Episode episode = new Episode("epi000001", "abc", 35,  "india",null, series1);
////		episodeService.addEpisode(episode);
//		
////-----------------Subscription with one to one user---------
//		
////		UserService service = applicationContext.getBean(UserService.class);
////		Register register;
////		register = new Register("ab000006","gokul6","km6","gokul6@gmail.com","ijkl1234",null, null,null);
////		register.setContactnumber(new BigDecimal("1234567890"));
////		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
////		Subscription subscription;
////		subscription = new Subscription("sub000001", "10/01/2022", 499.0f, "credit", "10/02/2022", "active", "monthly","false", register);
////	    subscriptionService.addSubscription(subscription);
////	    applicationContext.close();
//		
//		
//		//-----------------moviestriler--------
////		MovieService movieService = applicationContext.getBean(MovieService.class);
////		
////		Movie movie = new Movie();
////		movie.setId("mov000003");
////		movie.setAgeLimit("18");
////		movie.setCast("Allu Arjun");
////		movie.setLanguage("hindi");
////		movie.setLength(250);
////		movie.setMoviename("pushpa");
////		movie.setGenre("abc");
////		FileInputStream fileInputStream = null;
////		try {
////		 fileInputStream = new FileInputStream("C:\\Users\\gokul.km\\Downloads\\pushpa.mp4");
////		 long fileSize = new File("C:\\Users\\gokul.km\\Downloads\\pushpa.mp4").length();
////         byte[] allBytes = new byte[(int) fileSize];
////         
////         fileInputStream.read(allBytes);
////         
////         movie.setTrailer(allBytes);
////         
////         movie.setReleaseDate("2022-12-15");
////         movieService.addMovie(movie);
////         
////         
////		} catch (FileNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		finally {
////			try {
////				fileInputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
////		
////		movie.setTrailer(null);
//		
/////------------------
//		
////		MovieService movieService = applicationContext.getBean(MovieService.class);
////		FileOutputStream fileOutputStream = null;
////		try {
////			Optional<Movie> optional=movieService.getMovieById("mov000003");
////			if(optional.isEmpty()) {
////				System.out.println("movie record not found");
////			}
////			else {
////				//we should print the info and copy the file to movies folder with name pushpa2.
////				Movie movie=optional.get();
////				fileOutputStream = new FileOutputStream("C:\\Users\\gokul.km\\Downloads\\read\\pushpa2.mp4");
////				fileOutputStream.write(movie.getTrailer());
////			}
////		} catch (IdNotFoundException | NameNotFoundException | InvalidIdLengthException | IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		finally {
////				try {
////					fileOutputStream.close();
////				} catch (IOException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////			
////		}
//		
//		
////----------------
////MovieService movieService = applicationContext.getBean(MovieService.class);
////		
////		Movie movie = new Movie();
////		movie.setId("mov001");
////		
////		movie.setAgeLimit("18");
////		movie.setCast("Allu Arjun");
////		movie.setLanguage("hindi");
////		movie.setLength(250);
////		movie.setMoviename("pushpa");
////		movie.setGenre("abc");
////		FileInputStream fileInputStream = null;
////		FileOutputStream fileOutputStream = null;
////		try {
////		 fileInputStream = new FileInputStream("C:\\Users\\gokul.km\\Downloads\\pushpa.mp4");
////		 File file = new File("C:\\Users\\gokul.km\\Downloads\\pushpa.mp4");
////		 long fileSize= file.length();
////         byte[] allBytes = new byte[(int) fileSize];
////         
////         //fileInputStream.read(allBytes);
////         
////         movie.setTrailer("C:\\Users\\gokul.km\\Downloads\\movieStore\\"+file.getName());
////         
////         movie.setReleaseDate("2022-12-15");
////       String result =  movieService.addMovie(movie);
////       
////       if(result.equals("Successfully added movie")) {
////    	   
////    	   fileOutputStream = new FileOutputStream("C:\\Users\\gokul.km\\Downloads\\movieStore\\"+file.getName());
////    	   
////    	   //byte[] data = new byte[(int) file.length()];
////    	   
////    	   fileInputStream.read(allBytes);
////    	   fileOutputStream.write(allBytes);
////    	   
////       }
////         
////         
////		} catch (FileNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		finally {
////			try {
////				fileInputStream.close();
////				fileOutputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
//		
////---------------------movie trailer completed-------------------
//		
//		
////------------------episodes trailer---------
//		
//		
//		
//		//applicationContext.close();
//	}
//
//}
