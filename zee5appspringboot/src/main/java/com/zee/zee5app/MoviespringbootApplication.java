package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.MovieService;

@SpringBootApplication
public class MoviespringbootApplication {

	public static void main(String[] args) {
		
	ConfigurableApplicationContext applicationContext =	SpringApplication.run(MoviespringbootApplication.class, args);
	
//	DataSource dataSource = applicationContext.getBean(DataSource.class);
//	System.out.println(dataSource!=null);
//	
//	UserRepository userRepository  = applicationContext.getBean(UserRepository.class);
	
	System.out.println("Movie table");
	
	MovieService service = applicationContext.getBean(MovieService.class);
	Movie movie;
	
	// ------addmovie----------
	movie = new Movie("mov000001", "kgf", "A,B,C", 120, "10/01/2022", null, "kannada", "18", "action");
	System.out.println(service.addMovie(movie));
	movie = new Movie("mov000002", "pushpa", "A,B,C", 130, "20/01/2022", null, "kannada", "18", "action");
	System.out.println(service.addMovie(movie));


	
	//----------deletemovie---------
	try {
		System.out.println(service.deleteMovie("mov000002"));
	} catch (IdNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//-------getmoviebyid----------
	Optional<Movie> movie1 = null;

	try {
		movie1 = service.getMovieById("mov000001");
		if (movie1 != null) {
			System.out.println("Record found");
			System.out.println(movie1.get());
		} else {
			System.out.println("record is not found");
		}
	} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	//----------getallmovies------
	Optional<List<Movie>> optional;
	try {
		optional = service.getAllMovie();
		if (optional.isEmpty()) {
			System.out.println("no movie");
		} else {
			optional.get().forEach(e -> System.out.println(e));
		}
	} catch (InvalidIdLengthException | NameNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	
	}

	
	
	
	
	applicationContext.close();
	
	}
	
	

}