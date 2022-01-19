package com.zee.zee5app.service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MoviesRepository;



public class MoviesService {

	private MoviesRepository repository = MoviesRepository.getInstance();
	// service is consuming the repository
	
	private MoviesService() {
		// TODO Auto-generated constructor stub
	}
	// if we want ot create that single object then we have to create it
	// inside the same class
	// and we have to share ref with others
	// to do the same we have to declare a method.
	private static MoviesService  service = null;
	// this would be a static 
	// only one copy.
	
	public static MoviesService getInstance() {
		// it  becomes object independant?
		// static will make it independant on the object for execution.
		
		// static method will access only static ref
		if(service==null)
		service = new MoviesService();
		return service;
		
	}
	
	public String addMovies(Movies movie) {
		// do we need to consume the addUser method from repo.
		return this.repository.addMovies(movie);
	}
	
	public Movies getMoviesById(String id) {
		return repository.getMoviesById(id);
	}
	public Movies[] getMovies() {
		return repository.getMovies();
	}
	
	public String updateMovies(String id, Movies movie) {
		return repository.updateMovies("ab23", movie);
	}
}